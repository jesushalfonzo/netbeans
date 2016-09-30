/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf19.example;
import reference.jf19.example.Clinica.sex;

/**
 *
 * @author yecheverria
 */
public class Person {

    private final String name;
    private final String lastName;
    private final int ci;
    private final sex sex;

    public Person(String name, String lastName, int ci, sex sex) {
        this.name = name;
        this.lastName = lastName;
        this.ci = ci;
        this.sex = sex;
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

    public sex getSex() {
        return sex;
    }
    
    

}
