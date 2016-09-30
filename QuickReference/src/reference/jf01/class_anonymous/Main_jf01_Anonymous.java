/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf01.class_anonymous;

/**
 *
 * @author yecheverria
 */
public class Main_jf01_Anonymous {
    public static void main(String[] args) {
        Anonymous a = new Anonymous();
        System.out.println("cuadrado: " + a.getCuadradoAnonimo().calcularArea());
        System.out.println("rectangulo: " + a.getRectanguloAnonimo().calcularArea());
    }
}
