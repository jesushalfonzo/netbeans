/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf22.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author curso4
 */
public class ClienteManager {

    private DbSqlHelper db;

    public ClienteManager(DbSqlHelper db) {
        this.db = db;
    }

    public int save(ClienteBean cliente) throws SQLException, Exception {
        String sql = "INSERT INTO Clientes"
                + "(idCliente, nombre, apellido, cedula) VALUES ("
                + cliente.getIdCliente() + ",'"
                + cliente.getNombre() + "','"
                + cliente.getApellido() + "','"
                + cliente.getCedula() + "')";
        return db.executeUpdateSQL(sql);
    }

    public int update(ClienteBean cliente) throws SQLException, Exception {
        String sql = "UPDATE Clientes SET "
                + " nombre = '" + cliente.getNombre() + "',"
                + " apellido ='" + cliente.getApellido() + "',"
                + " cedula ='" + cliente.getCedula() + "'"
                + " WHERE idCliente = " + cliente.getIdCliente();
        return db.executeUpdateSQL(sql);
    }

    public int deleteById(ClienteBean cliente) throws SQLException, Exception {
        String sql = "DELETE FROM Clientes "
                + "WHERE idCliente = " + cliente.getIdCliente();
        return db.executeUpdateSQL(sql);
    }

    public ResultSet selectById(ClienteBean cliente) throws SQLException, Exception {
        String sql = "SELECT * FROM CLientes "
                + "WHERE idCliente=" + cliente.getIdCliente();

        return db.executeQuerySQL(sql);
    }

    public ClienteBean selectBeanById(ClienteBean cliente) throws SQLException, Exception {
        ResultSet rs = selectById(cliente);
        if (!rs.next()) {
            return null;
        }
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setCedula(rs.getString("cedula"));
        return cliente;
    }

    public static void main(String[] p) {
    }
}
