/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.beans;

/**
 *
 * @author curso1
 */
public abstract class Person {

    private String name;
    private String lastName;
    private String dateOfBirth;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
