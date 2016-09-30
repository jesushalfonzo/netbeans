/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf22.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

/**
 *
 * @author yecheverria
 */
public class DbSqlHelper {

    static Logger logger = Logger.getLogger(DbSqlHelper.class.getName());
    private Connection conn;
    private ResultSet rs;
    Properties connectionProps = new Properties();
    String dbName;

    /**
     * Assign name db, user and password.
     *
     * @param dbName
     * @param user
     * @param psw
     */
    public DbSqlHelper(String dbName, String user, String psw) {
        connectionProps.put("user", user);
        connectionProps.put("password", psw);
        this.dbName = dbName;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbSqlHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DbSqlHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DbSqlHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized Connection getConnection() throws SQLException, NamingException, Exception {
        if ((conn != null) && (!conn.isClosed())) {
            return conn;
        }
        conn = null;
        try {
            logger.log(Level.INFO, "Conecting to... {0}", dbName);
//            conn = DriverManager.getConnection("jdbc:mysql:" + dbName, connectionProps

            conn = DriverManager.getConnection(dbName, connectionProps);

//          conn = DriverManager.getConnection("jdbc:oracle:thin:@WIN01:1521:oracleBD", connectionProps);
            // driver@machineName:port:SID           ,  userid,  password
            logger.log(Level.INFO, "Conected to !!!... {0}", dbName);
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, "Failed Conecting to ***... {0}", dbName);
            throw sqle;
        }
        return conn;
    }

    public synchronized ResultSet executeQuerySQL(String sql) throws SQLException, Exception {
        PreparedStatement ps = getConnection().prepareStatement(sql);
        logger.log(Level.INFO, "Executing Query ... {0}", sql);
        return ps.executeQuery();
    }

    public synchronized int executeUpdateSQL(String sql) throws SQLException, Exception {
        PreparedStatement ps = getConnection().prepareStatement(sql);
        logger.log(Level.INFO, "Executing Updating Query ... {0}", sql);
        return ps.executeUpdate();
    }

    public void close() {
        try {
            logger.log(Level.INFO, "Closing DataBase connection... {0}", dbName);
            conn.close();
            logger.log(Level.INFO, "Closed DataBase connection !!!... {0}", dbName);
        } catch (SQLException sqle) {
            logger.log(Level.WARNING, "Exception closing DataBase connection !!!... {0} \n "
                    + "Exception : {1}", new Object[]{dbName, sqle});
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception closing DataBase connection !!!... {0} \n "
                    + "Exception : {1}", new Object[]{dbName, e});
        } finally {
            conn = null;
        }
    }

    public static void main(String[] s) throws Exception {
        DbSqlHelper db = new DbSqlHelper("jdbc:derby://localhost:1527/curso", "curso", "12345678");
        int var = 12;
        String nombre = "";
        String apellido = "";
        String cedula = "";
        int respuesta = JOptionPane.showConfirmDialog(null, "Mensaje", "Titulo", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.out.println("Su respuesta fue SI!!!!!!");
            ResultSet rs = db.executeQuerySQL("UPDATE Clientes"
                    + " SET nombre ='" + nombre + "'"
                    + " apellido ='" + apellido + "'"
                    + " cedula ='" + cedula + "'"
                    + " WHERE idCliente =" + var);
            JOptionPane.showConfirmDialog(null, "Actualizacion Exitosa!");
        }
//        ResultSet rs = db.executeQuerySQL("SELECT * FROM Clientes WHERE idCliente = " + var);

//        int a = 3;
//        String var1 = "alguna", var2 = "cosa", var3 = "al azar";
//        String sql1 = "INSERT INTO Clientes (idcliente, nombre, apellido, cedula)"
//                + " VALUES (" + a + ", '" + var1 + "', '" + var2 + "', '" + var3 + "')";
        //db.executeUpdateSQL(sql1);
//        while (rs.next()) {
//        if (rs.next()) {
//            System.out.println(rs.getInt("idCliente"));
//            System.out.println(rs.getString("nombre"));
//            System.out.println(rs.getString("Apellido"));
//        }
//        rs.next();
//        rs.next();
//        rs.next();
//        rs.next();
//        rs.next();
//        if (rs.next()) {
//            System.out.println(rs.getInt("idCliente"));
//            System.out.println(rs.getString("nombre"));
//            System.out.println(rs.getString("Apellido"));
//        } else {
//            System.out.println("No hay mas");
//        }
//        }
//        rs.close();
//        db.close();
    }
//        int ts = db.executeUpdateSQL("INSERT INTO Clientes (idCliente, NOMBRE, APELLIDO, CEDULA)"
//                + " VALUES (2, 'Shera', 'Valera', 'V16895633')");
}
