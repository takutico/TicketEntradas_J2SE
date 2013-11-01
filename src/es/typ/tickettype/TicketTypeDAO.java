/*0
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.typ.tickettype;

import es.typ.datebase.DataBase;
import es.typ.utils.Log;
import es.typ.utils.PropertyManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takuya
 */
public class TicketTypeDAO {
    
    DataBase dataBase = new DataBase();
    //private PropertyManager p = new PropertyManager("TicketEntradas_J2SE.properties");
    private static String ipservidor = PropertyManager.getInstance().getProperty("ipservidor");
    private static String password = PropertyManager.getInstance().getProperty("password");

    public void insertTicket(TicketTypeData ticketTypeData) {
        String sql = "INSERT INTO ticket_entradas.tickettype(name, price, category)" +
                     "VALUES ("
                + "'" + ticketTypeData.getName() + "', "
                + "'" + ticketTypeData.getPrice() + "', "
                + ticketTypeData.getCategory() + ")";
        Log.getInstance().log(sql);
        dataBase.executeUpdate(sql);
    }

    public ArrayList getTicketTypeOrderByCategory() {
        /*Variable para almacenar la URL de conexión a nuestra Base de Datos, si esta estuviera en otra máquina, necesitariamos estar registrados en ella y contar con su IP*/
        //postgres es el nombre de la base de datos
        String url = "jdbc:postgresql://" + ipservidor + "/postgres";
        ArrayList result = new ArrayList();
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
            String query = "select * from ticket_entradas.tickettype order by category, name";

//En el ResultSet guardamos el resultado de ejecutar la consulta
            Log.getInstance().log(query);
            rs = stmt.executeQuery(query);

//En un ciclo while recorremos cada fila del resultado de nuestro Select
            while (rs.next()) {

                /*Aqui practicamente podemos hacer lo que deseemos con el resultado, en mi caso solo lo mande a imprimir*/
                //System.out.println("id = " + rs.getString("id") + " name = " + rs.getString("name") + " price = " + rs.getString("price"));
                result.add(new TicketTypeData(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("price"), rs.getString("category")));
            }
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
        }finally {
            try {
                stmt.execute("END");
            } catch (SQLException ex) {
                Logger.getLogger(TicketTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return result;
    }

    public ArrayList getTicketType() {
        /*Variable para almacenar la URL de conexión a nuestra Base de Datos, si esta estuviera en otra máquina, necesitariamos estar registrados en ella y contar con su IP*/
        //postgres es el nombre de la base de datos
        String url = "jdbc:postgresql://" + ipservidor + "/postgres";
        ArrayList result = new ArrayList();
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
            String query = "select * from ticket_entradas.tickettype order by id";

//En el ResultSet guardamos el resultado de ejecutar la consulta
            Log.getInstance().log(query);
            rs = stmt.executeQuery(query);

//En un ciclo while recorremos cada fila del resultado de nuestro Select
            while (rs.next()) {

                /*Aqui practicamente podemos hacer lo que deseemos con el resultado, en mi caso solo lo mande a imprimir*/
                //System.out.println("id = " + rs.getString("id") + " name = " + rs.getString("name") + " price = " + rs.getString("price"));
                result.add(new TicketTypeData(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("price"), rs.getString("category")));
            }
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
        }finally {
            try {
                stmt.execute("END");
            } catch (SQLException ex) {
                Logger.getLogger(TicketTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return result;
    }
    public int getIdTicketType(String name) {
        /*Variable para almacenar la URL de conexión a nuestra Base de Datos, si esta estuviera en otra máquina, necesitariamos estar registrados en ella y contar con su IP*/
        //postgres es el nombre de la base de datos
        String url = "jdbc:postgresql://" + ipservidor + "/postgres";
        //ArrayList result = new ArrayList();
        int idType = 0;
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
            String query = "select id from ticket_entradas.tickettype where UPPER(name) = '" + name + "'";

//En el ResultSet guardamos el resultado de ejecutar la consulta
            Log.getInstance().log(query);
            rs = stmt.executeQuery(query);
            rs.next();
            idType = Integer.parseInt(rs.getString("id"));
//En un ciclo while recorremos cada fila del resultado de nuestro Select
            //while (rs.next()) {
                //idType = Integer.parseInt(rs.getString("id"));
                /*Aqui practicamente podemos hacer lo que deseemos con el resultado, en mi caso solo lo mande a imprimir*/
                //System.out.println("id = " + rs.getString("id") + " name = " + rs.getString("name") + " price = " + rs.getString("price"));
                //result.add(new TicketTypeData(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("price"), rs.getString("category")));
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
        }finally {
            try {
                stmt.execute("END");
            } catch (SQLException ex) {
                Logger.getLogger(TicketTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return idType;
    }

        public TicketTypeData getIdAndPriceFromTicketType(String name) {
        /*Variable para almacenar la URL de conexión a nuestra Base de Datos, si esta estuviera en otra máquina, necesitariamos estar registrados en ella y contar con su IP*/
        //postgres es el nombre de la base de datos
        String url = "jdbc:postgresql://" + ipservidor + "/postgres";
        //ArrayList result = new ArrayList();
        //int idType = 0;
        TicketTypeData ticketTypedata = new TicketTypeData();
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
            String query = "select id, price from ticket_entradas.tickettype where UPPER(name) = '" + name + "'";

//En el ResultSet guardamos el resultado de ejecutar la consulta
            Log.getInstance().log(query);
            rs = stmt.executeQuery(query);
            rs.next();
            //idType = Integer.parseInt(rs.getString("id"));

            ticketTypedata.setId(Integer.parseInt(rs.getString("id")));
            ticketTypedata.setPrice(rs.getString("price"));

//En un ciclo while recorremos cada fila del resultado de nuestro Select
            //while (rs.next()) {
                //idType = Integer.parseInt(rs.getString("id"));
                /*Aqui practicamente podemos hacer lo que deseemos con el resultado, en mi caso solo lo mande a imprimir*/
                //System.out.println("id = " + rs.getString("id") + " name = " + rs.getString("name") + " price = " + rs.getString("price"));
                //result.add(new TicketTypeData(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("price"), rs.getString("category")));
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
        }finally {
            try {
                stmt.execute("END");
            } catch (SQLException ex) {
                Logger.getLogger(TicketTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return ticketTypedata;
    }


    void updateTicket(TicketTypeData ticketTypeData) {
        String sql = "UPDATE ticket_entradas.tickettype" +
                " SET name = '" + ticketTypeData.getName() + "',"
                + " price = '" + ticketTypeData.getPrice() + "',"
                + " category = " + ticketTypeData.getCategory()
                + " WHERE id = " + ticketTypeData.getId();
        Log.getInstance().log(sql);
        dataBase.executeUpdate(sql);
    }

}
