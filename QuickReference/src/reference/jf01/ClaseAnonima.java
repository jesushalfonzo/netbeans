/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf01;

/**
 *
 * @author curso1
 */
public class ClaseAnonima {

    public static void main(String[] p) {
        InterfaceAnonima ita;
        ita = new InterfaceAnonima() {
            @Override
            public void metodo1() {
                System.out.println("Metodo 1");
            }

            @Override
            public void metodo2() {
                System.out.println("Metodo 2");
            }

            @Override
            public void metodo3() {
                System.out.println("Metodo 3");
            }

            @Override
            public String metodo4(String name) {
                System.out.println("Nombre");
                return name;
            }
        };
    }
}
