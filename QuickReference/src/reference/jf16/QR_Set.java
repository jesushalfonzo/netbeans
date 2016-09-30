/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf16;

import java.util.HashSet;
import java.util.Set;
import reference.beans.Ciudadano;

/**
 *
 * @author curso1
 */
public class QR_Set {

    private Set<String> sString = new HashSet<>();
    private Set<Ciudadano> sCitizens = new HashSet<>();

    public void QR_HashSet() {
        boolean add = false;
        /*
         * Incluir objetos
         */
        sString.add("Caracas");
        sString.add("Magallanes");
        sString.add("Tigres");
        sString.add("La Guaira");
        /*
         * Set no acepta repetidos.
         */
        add = sString.add("Magallanes");


        if (!add) {
            System.out.println("Repetido");
        }
        /*
         * lo anterior pudo haber sido
         *  if ( !sString.add("Magallanes") ) {
         *      System.out.println("Repetido");
         * }
         }
         */

        for (String equipos : sString) {
            System.out.println(equipos);
        }
    }

    /*
     * Valida si el elemento fue añadido o no.
     */
    public void QR_HashSet01() {
        addonset("Caracas");
        addonset("Tigres");
        addonset("Magallanes");
        addonset("Bravos");
        addonset("Magallanes");
    }

    public void QR_HashSetObject() {
        Ciudadano objC = new Ciudadano("Martha");

        sCitizens.add(new Ciudadano("Sandra"));
        sCitizens.add(objC);
        sCitizens.add(new Ciudadano("Ramona"));
        sCitizens.add(new Ciudadano("Andrea"));
        /*
         * este objeto es guardado en sCitizen
         * porque "new" genera un valor de referencia nuevo
         */
        sCitizens.add(new Ciudadano("Ramona"));
        /*
         * Se cambia el nombre de Martha a Prueba
         */
        objC.setName("Prueba");
        /*
         * este objeto no es guardado en sCitizen
         * porque el valor "de referencia" que tiene
         * objC ya fue guardado anteriormente.
         */
        sCitizens.add(objC);
        /*
         * un Set no tiene un orden en especifico para 
         * mostar sus datos
         */
        for (Ciudadano ciudadano : sCitizens) {
            System.out.println(ciudadano.getName());
        }
    }

    /*
     * metodo que intenta añadir un elemento tipo String.
     * si existe envia el mensaje "fue añadido",
     * si no existe, lo añade y envvia el mensaje "fue añadido".
     */
    private void addonset(String element) {
        if (sString.add(element)) {
            System.out.println("El elemento" + element + " fue añadido");
        } else {
            System.out.println("El elemento" + element + " esta repetido, No fue añadido");
        }
    }

    public static void main(String[] p) {
        QR_Set oqr = new QR_Set();
//        oqr.QR_HashSet();
//        oqr.QR_HashSetObject();
        oqr.QR_HashSet01();
    }
}