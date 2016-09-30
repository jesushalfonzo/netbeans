/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf02;

/**
 *
 * @author curso1
 */
public abstract class Metodos {

    /*
     Es un metodo que no tiene cuerpo o no esta implementado.
     */
    public abstract void metAbst();
    /*
     Se puede acceder a el sin necesidad e crear un objeto.
     */

    public static void metClase() {
    }
    /*
     No puede ser sobre escrito
     */

    public final void metNoSobreEsc() {
    }
    /*
     metodo sobre cargado.
     */

    public String metSobreCar() {
        return "casa";
    }

    public String metSobreCar(int num, String name) {
        num = num + 1;
        return "mesa";
    }
}
