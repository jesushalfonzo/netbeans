/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Intensivo;

/**
 *
 * @author curso1
 */
public class MainFrutas {

    public static void main(String[] agrs) {

        Mango mag = new Mango("Amarillo", "Soy un mango");
        System.out.println("hola mi color es " + mag.getColor() + " y " + mag.getNombre());

        Pera per = new Pera();
        per.setColor("Verde");
        per.setNombre("Soy una pera");
        System.out.println("hola mi color es " + per.getColor() + " y " + per.getNombre());
    }
}
