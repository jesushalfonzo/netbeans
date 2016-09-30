/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf18.example;

/**
 *
 * @author yecheverria
 */
public class Mango implements Fruit{

    @Override
    public int hashCode() {
        return -3456;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mango other = (Mango) obj;
        return true;
    }
    
}
