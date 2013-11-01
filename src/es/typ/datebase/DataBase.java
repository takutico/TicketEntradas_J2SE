package es.typ.datebase;

import es.typ.utils.Log;
import es.typ.utils.PropertyManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TYP - Takuya Yamaguchi Padilla
 */
public class DataBase {

    private static String ipservidor = PropertyManager.getInstance().getProperty("ipservidor");
    private static String password = PropertyManager.getInstance().getProperty("password");

    public void executeUpdate(String sql) {
        /*Variable para almacenar la URL de conexión a nuestra Base de Datos, si esta estuviera en otra máquina, necesitariamos estar registrados en ella y contar con su IP*/
        String url = "jdbc:postgresql://" + ipservidor + "/postgres";
        Connection con = null;
        Statement stmt = null;

        try {

//Acceso al Driver
            Class.forName("org.postgresql.Driver");

//La conexión con los parámetros necesarios
            con = DriverManager.getConnection(url, "postgres", password);

//Abrimos la conexión y la iniciamos
            stmt = con.createStatement();

//Ejecutamos la consulta SQL
            Log.getInstance().log(sql);
            stmt.executeUpdate(sql);

//Cerramos la conexión
            
        } catch (Exception e) {

//Por si ocurre un error
            System.out.println(e.getMessage());
            e.printStackTrace();
            Log.getInstance().log(e.getMessage());
        } finally{
            try {
                stmt.execute("END");
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void executeQuery(String sql){

    }
}
