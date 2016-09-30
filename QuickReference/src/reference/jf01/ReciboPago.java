/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author curso1
 */
public class ReciboPago {

    private int num;
    List<Items> it = new ArrayList<>();

    private class Items {

        private String description;
        private float amount; //Float porque solo tiene ceros a la izquierda

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(float amount) {
            this.amount = amount;
        }
        
        
       
    }
}
