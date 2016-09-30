/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf18;

import reference.beans.Ciudadano;

/**
 *
 * @author curso1
 */
public class MainBox {

    public static void main(String[] p) {
        Ciudadano ciudadano = new Ciudadano("Jhonny");
        String var = "Prueba";
        BoxObject b = new BoxObject();

        b.setObject(ciudadano);
        Object o = b.getObject();
        /*
         * Como getObject retorna un objeto necesito hacer un casting
         * a Ciudadano para poder usar los metodos de este.
         */

        Ciudadano c = (Ciudadano) b.getObject();

        System.out.println(c.getName());

//        ************************************
        /* Al declarar la variable tipo Box Ciudadano
         * estamos diciendo que T en la clase Box es Ciudadano.
         * 
         */
        Box<Ciudadano> box = new Box<>();

        box.setObject(ciudadano);
        c = box.getObject();
        System.out.println(c.getName());
        System.out.println(box.getObject().getName());

//        ************************************
        Box<String> sBox = new Box<>();
        sBox.setObject("Generics");
        System.out.println(sBox.getObject());

    }
}
