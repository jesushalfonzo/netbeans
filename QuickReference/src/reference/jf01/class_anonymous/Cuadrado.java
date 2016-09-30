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
public class Cuadrado implements FigurasGeometricasInterface {

    @Override
    public float calcularArea() {
        return 2 * 2;
    }

    @Override
    public void dibujame() {
        System.out.println("Dibujando un cuadrado");
    }
}
