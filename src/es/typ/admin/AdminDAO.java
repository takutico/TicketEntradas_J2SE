package es.typ.admin;

import es.typ.datebase.DataBase;
import es.typ.utils.Log;
import es.typ.utils.PropertyManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TYP - Takuya Yamaguchi Padilla
 */
public class AdminDAO {
    
    private DataBase dataBase = new DataBase();
    private static String ipservidor = PropertyManager.getInstance().getProperty("ipservidor");
    private static String password = PropertyManager.getInstance().getProperty("password");

    public void insertAdmin(AdminData admindata) {
        String sql = "INSERT INTO ticket_entradas.administrator(adminname, pass)"
                + " VALUES ("
                + "'" + admindata.getAdminLogin() + "', "
                + "'" + admindata.getAdminPass() + "')";
        dataBase.executeUpdate(sql);
    }

    public int loginAdmin(AdminData adminData){


        /*Variable para almacenar la URL de conexión a nuestra Base de Datos, si esta estuviera en otra máquina, necesitariamos estar registrados en ella y contar con su IP*/
        //postgres es el nombre de la base de datos
        String url = "jdbc:postgresql://" + ipservidor + "/postgres";
        //ArrayList result = new ArrayList();
        int result = 0;
        Connection con = null;
        Statement stmt = null;
        try {

//Acceso al Driver
            Class.forName("org.postgresql.Driver");

//La conexión con los parámetros necesarios
            con = DriverManager.getConnection(url, "postgres", password);

//Abrimos la conexión y la iniciamos
             stmt = con.createStatement();

            /*Un ResultSet es como en .NET un DataSet, un arreglo temporal donde se almacenará el resultado de la consulta SQL*/
            ResultSet rs;

//Una variable String para almacenar la sentencia SQL
            String query = "select idadmin "
                    + " from ticket_entradas.administrator"
                    + " where adminname = '" + adminData.getAdminLogin() + "'";

//En el ResultSet guardamos el resultado de ejecutar la consulta
            rs = stmt.executeQuery(query);
            rs.next();
            result = Integer.parseInt(rs.getString("idadmin"));
//En un ciclo while recorremos cada fila del resultado de nuestro Select
            //while (rs.next()) {
                //idType = Integer.parseInt(rs.getString("id"));
                /*Aqui practicamente podemos hacer lo que deseemos con el resultado, en mi caso solo lo mande a imprimir*/
                //System.out.println("id = " + rs.getString("id") + " name = " + rs.getString("name") + " price = " + rs.getString("price"));
                //Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("price"), rs.getString("category"))
                //result.add(new TicketData(Integer.parseInt(rs.getString("people")), rs.getString("name"), rs.getString("date"), rs.getString("hour")));
            //}
            /*
            id integer NOT NULL,
            "name" character varying(50) NOT NULL,
            price character varying(10) NOT NULL,
            category integer NOT NULL,
             */
//Cerramos la conexión

        } catch (Exception e) {

//Por si ocurre un error
            System.out.println(e.getMessage());
            e.printStackTrace();
            Log.getInstance().log(e.getMessage());
            return -1;
        } finally {
            try {
                stmt.execute("END");
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;

    }

}
