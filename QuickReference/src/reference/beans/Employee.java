/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.beans;

/**
 *
 * @author curso1
 */
public final class Employee extends Ciudadano {

    private String cargo;

    public Employee(String name) {
        this(0, name, "standard");
    }

    public Employee(int cedula, String name, String cargo) {
        super(cedula, name);
        this.cargo = cargo;
    }
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
