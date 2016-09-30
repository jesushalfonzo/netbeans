/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf19.example01;

/**
 *
 * @author yecheverria
 */
public class Persona {
    private String name;
    private String lastName;
    private int ci;

    public Persona(String name, String lastName, int ci) {
        this.name = name;
        this.lastName = lastName;
        this.ci = ci;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCi() {
        return ci;
    }
    
    
}
