/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf13;

import reference.beans.Ciudadano;

/**
 *
 * @author yech
 */
public class QR_Arrays {
    /*
     * declarar e instanciar un array int de 5.
     * ejem I:
     */

    private int[] aInt = new int[5];
    /* ejem II:
     *    private int[] aInt = {1, 4, 45, 23, 67};
     */

    /*
     * declarar e instanciar un array float de 4.
     */
    private float[] aFloat = new float[4];
    /*
     * declarar e instanciar un array boolean de 7.
     */
    private boolean[] aBoolean = new boolean[7];
    /*
     * declarar e instanciar un array String de 4.
     * ejem I:
     *     private String[] aString = new String[4];
     */
    private String[] aString = {"carro", "casa", "calor", "cumbre"};
    /*
     * declarar e instanciar un array Ciudadano de 3.
     * ejem I:
     *     private Ciudadano[] aCiudadano = {new Ciudadano(),new Ciudadano(), new Ciudadano() };
     * 
     */
    private Ciudadano[] aCiudadano = new Ciudadano[3];

    public int[] TestingArrayInt(int... size) {
        int[] aInt = size;

        /*
         * Asignarle valores a un Array: I
         * ejem:
         *    nombreArray[posicion] = valor;
         *    aInt[0] = 1;
         *    aInt[1] = 8;
         */

        /*
         * recorrer un array con ciclo for
         */
        for (int i = 0; i < aInt.length; i++) {
            System.out.println("Posicion " + i + ": " + aInt[i]);
        }

        return aInt;
    }

    public String[] TestingArrayString(String... values) {
        String[] aString = new String[2];

        if (values.length != 0) {
            aString = values;
        }

        /*
         * Asignarle valores a un Array: I
         * ejem:
         *    nombreArray[posicion] = valor;
         *    aString[0] = "Hola";
         *    aString[1] = "Adios";
         */

        /*
         * recorrer un array con ciclo for
         */
        for (int i = 0; i < aString.length; i++) {
            System.out.println("Posicion " + i + ": " + aString[i]);
        }

        return aString;
    }

    public Ciudadano[] TestingArrayCiudadano(Ciudadano... values) {
        Ciudadano[] aCiudadano = new Ciudadano[2];

        if (values.length != 0) {
            aCiudadano = values;
        }

        /*
         * Asignarle valores a un Array: I
         * ejem:
         *    nombreArray[posicion] = valor;
         *    aCiudadano[0] = new Ciudadano();
         *    aCiudadano[1] = new Ciudadano();
         */

        /*
         * recorrer un array con ciclo for
         */
        for (int i = 0; i < aCiudadano.length; i++) {
            System.out.println("Posicion " + i + ": " + aCiudadano[i].getName());
        }

        return aCiudadano;
    }

    public static void main(String[] p) {
        QR_Arrays arr = new QR_Arrays();
        String[] s = {"uno", "dos", "tres", "cuatro"};
        arr.TestingArrayString();
        Ciudadano[] c = {new Ciudadano("Jose"), new Ciudadano("Juan")};
        arr.TestingArrayCiudadano(c);
    }
}
