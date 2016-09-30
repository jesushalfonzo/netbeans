/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf20;

import java.util.logging.Level;
import java.util.logging.Logger;
import static reference.jf20.MainThread._stop;

/**
 *
 * @author curso1
 */
public class Consumidor implements Runnable {

    private Almacen almacen;
    private String name;

    /*
     * el constructor recibe un tipo Almacen dado que Productor
     * y Consumidor DEBEN trabajar sobre el mismo almacen.
     * De no enviarlo en el constructor entonces deberia crear en el 
     * Main una variable tipo Almacen que sea static.
     * 
     * En este caso, recibo tambien un String que representa el nombre
     * del hilo.
     */
    public Consumidor(Almacen almacen, String name) {
        this.almacen = almacen;
        this.name = name;
    }

    @Override
    public void run() {
        /*
         * hacer un ciclo infinito.
         */
        while (!_stop) {
            try {
                /*
                 * obtener un producto del almacen.
                 */
                System.out.println("consumido por :" + name + " " + almacen.getProducto(name));
                /*
                 * 'Dormir' este hilo un tiempo aleatorio.
                 */
                Thread.sleep((long)Math.random() * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        almacen.cerrarAlmacen();
    }
}
