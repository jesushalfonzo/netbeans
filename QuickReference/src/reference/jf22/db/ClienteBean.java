/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf22.db;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author curso4
 */
public class ClienteBean {

    /* Representa los campos y sus length maximos.
     * 
     */
    public static enum Cliente_size {

        nombre(70), apellido(100), cedula(10);
        int length;

        private Cliente_size(int length) {
            this.length = length;
        }

        /**
         * Devuelve el len maximo del enum seleccionado.
         *
         * @return
         */
        public int getMaxLength() {
            return length;
        }

        /**
         * Valida el tamano del campo. Lanza una exception si el length enviado
         * es mayor al aceptado por el campo.
         *
         * @param actualLength
         * @throws Exception
         */
        public void validLength(int actualLength) throws Exception {
            if (actualLength > length) {
                throw new Exception();
            }
        }

        /**
         * Valida el tamano del campo. Retorna false si es mayor o verdadero si
         * es menor o igual.
         *
         * @param actualLength
         * @return
         */
        public boolean isValidLength(int actualLength) {
            if (actualLength > length) {
                return false;
            }
            return true;
        }
    }
    private int idCliente;
    private String nombre;
    private String Apellido;
    private String cedula;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public static void main(String[] p) {
        JOptionPane.showConfirmDialog(null, "El cliente ya existe. Modificar?", "Clientes", JOptionPane.YES_NO_OPTION);
        System.out.println(Cliente_size.cedula.getMaxLength());
        System.out.println(Cliente_size.apellido.isValidLength(10));
        System.out.println(Cliente_size.nombre.isValidLength(10));
        try {
            Cliente_size.nombre.validLength(11414);
        } catch (Exception ex) {
            System.out.println("Tamano no valido");
        }
    }
}
