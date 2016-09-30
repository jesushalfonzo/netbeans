/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import reference.beans.Ciudadano;

/**
 *
 * @author curso1
 */
public class QR_List {

    ArrayList al = new ArrayList();
    Vector v = new Vector();

    /*
     * Uso de Arrays con v1.4 o anterior.
     */
    public void arrayListOld() {
        ArrayList al = new ArrayList();
        al.add(new Integer(5));
        al.add(new Integer("4"));
        al.add(new Integer(6));
        /*
         * Estoy Guardando un objeto Ciudadano y anteriormente
         * solo guardaba onjetos Integer.
         */
        al.add(new Ciudadano("Hola"));
        int sum = 0;
        for (Iterator it = al.iterator(); it.hasNext();) {
            Object object = it.next();
            /*
             * Estoy convirtiendo a int cada objeto devuelto por
             * el ArrayList al pero al intentar el cast con el
             * objeto Ciudadano obtengo un error.
             */
            sum += Integer.parseInt(object.toString());
            System.out.println("objeto :" + sum);
        }

    }

    /*
     * Version Actual.
     */
    public void arrayList() {
        /*
         * Indicarle al ArrayList que solo va a aceptar tipo Integer.
         */
        List<Integer> al = new ArrayList<>();
        al.add(new Integer(5));
        al.add(new Integer("4"));
        al.add(new Integer(6));
        al.add(5);
        Integer integer2;
        int a = 3;

        // AutoBoxing
        integer2 = 2;
        // UnBoxing;
        a = integer2;

        int sum = 0;
        for (Integer integer : al) {
            sum += integer;
            System.out.println("valor " + sum);
        }
    }

    public void arrayVector() {
        /*
         * Indicarle al Vector que solo va a aceptar tipo String.
         */
        List<String> vc = new Vector<>();
        vc.add("Pedro");
        vc.add("Yedoska");
        vc.add("Ana");
        /*
         * List acepta repetidos.
         */
        vc.add("Ana");
        /*
         * for (NombreDeTipoDevuelto nombreDeLaVariable : nombreDelObjetoParaRecorrer){
         * }
         * String -> Es lo que contiene el Vector.
         * c -> Es donde guarda el objeto actual en el recorrido(tipo: String).
         * vc -> es el Collections a recorrer.
         */
        for (String string : vc) {
            System.out.println(string);
        }
    }

    public void arrayVectorObject() {
        /*
         * Indicarle al Vector que solo va a aceptar tipo Ciudadano.
         */
        List<Ciudadano> vc = new Vector<>();
        /*
         * Declarar e instanciar un objeto tipo Ciudadano.
         */
        Ciudadano ciu = new Ciudadano("Pedro");
        /*
         * Instanciar un objeto ciudadano y guardarlo en el Vector vc.
         */
        vc.add(new Ciudadano("Yedoska"));
        vc.add(new Ciudadano("Ana"));
        vc.add(ciu);
        /*
         * for (NombreDeTipoDevuelto nombreDeLaVariable : nombreDelObjetoParaRecorrer){
         * }
         * Ciudadano -> Es lo que contiene el Vector.
         * c -> Es donde guarda el objeto actual en el recorrido(tipo: Ciudadano).
         * vc -> es el Collections a recorrer.
         */
        for (Ciudadano c : vc) {
            System.out.println(c.getName());
        }
    }

    public List<Ciudadano> aCiudadano() {
        /*
         * Como ArrayList implementa la Interface List
         * puedo guardar el objeto ArrayList en un List.
         */
        List<Ciudadano> c = new ArrayList<>();
        c.add(new Ciudadano("Array"));
        recorrerList(c);
        return c;
    }

    public List<Ciudadano> vCiudadano() {
        /*
         * Como Vector implementa la Interface List
         * puedo guardar el objeto Vector en un List.
         */
        List<Ciudadano> c = new Vector<>();
        c.add(new Ciudadano("Vector"));
        recorrerList(c);
        return c;
    }

    /*
     * Como List es una Interfaz puedo enviarle como parametro cualquier objeto
     * que la implemente.
     */
    private void recorrerList(List<Ciudadano> list) {
        for (Ciudadano ciudadano : list) {
            System.out.println(ciudadano.getName());
        }
    }

    public static void main(String[] p) {
        QR_List list = new QR_List();
//        list.arrayListOld();
//        list.arrayList();
//        System.out.println("******* 1 ********");
        list.arrayVector();
//        System.out.println("******* 2 *******");
//        list.arrayVectorObject();
//        System.out.println("******* 3 *******");
//        list.aCiudadano();
//        list.vCiudadano();
    }
}
