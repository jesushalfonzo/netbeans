/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.beans;

/**
 *
 * @author yech
 */
public class Ciudadano extends Person {

    private int id;

    public Ciudadano() {
    }

    public Ciudadano(String name) {
        this(0, name);
    }

    public Ciudadano(int cedula, String name) {
        super(name);
        this.id = cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
