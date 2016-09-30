/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf08;

/**
 *
 * @author curso1
 */
public class Operadores {

    private int siete;
    private int dos;
    private int cinco;

    public void masmastAntes(int siete, int dos) {
        if (siete == ++dos) {
            System.out.println("Es igual :" + siete + "==" + dos);
        }
    }

    public void masmastDespues(int siete, int dos) {
        if (siete == dos++) {
            System.out.println("Es igual :" + siete + "==" + dos);
        }
    }

    public void mayorOmenor(int siete, int dos) {
        if (siete > dos) {
            System.out.println("Es mayor");
        }
        if (siete >= dos) {
            System.out.println("Es mayor o igual");
        }
        if (siete < dos) {
            System.out.println("Es menor");
        }
        if (siete <= dos) {
            System.out.println("Es menor o igual");
        }
    }
}
