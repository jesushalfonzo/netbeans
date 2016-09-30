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
public class Productor implements Runnable {

    private Almacen almacen;

    /*
     * el constructor recibe un tipo Almacen dado que Productor
     * y Consumidor DEBEN trabajar sobre el mismo almacen.
     * De no enviarlo en el constructor entonces deberia crear en el 
     * Main una variable tipo Almacen que sea static.
     */
    public Productor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        /*
         * crear un ciclo infinito.
         */
        while (!_stop) {
            /*
             * crear un numero aleatorio.
             */
            int num = (int) (Math.random() * 1000);
            /*
             * guardar ese numero creado en la lista de almacen.
             */
            almacen.setProducto(num);
            System.out.println("Producido..." + num);
            try {
                /*
                 * 'Dormir' un tiempo aleatorio antes de continuar produciendo.
                 */
                Thread.sleep(Math.round(Math.random() * 300));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        almacen.cerrarAlmacen();
    }
}
