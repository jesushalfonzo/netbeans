/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf20;

import java.util.ArrayList;
import java.util.List;
import static reference.jf20.MainThread._stop;

/**
 *
 * @author curso1
 */
public class Almacen {
    /*
     * Crear un List de enteros que representa la data a utilizar.
     */

    List<Integer> productos = new ArrayList<>();

    /**
     * Devuelve un entero de la lista y escribe el nombre del hilo que llamo al
     * metodo.
     *
     * @param name nombre del hilo que lo esta llamando.
     * @return Integer
     * @throws InterruptedException
     */
    public synchronized Integer getProducto(String name) throws InterruptedException {
        /*
         * Preguntar si la lista esta vacia.
         */
        if (productos.isEmpty()) {
            System.out.println("Esperando...." + name);
            /*
             * Si no hay datos en la lista decirle al hilo que se espere.
             */
            wait();
        }
        if (_stop) {
            System.out.println(productos.size());
            return null;
        }
        /*
         * asignar el entero que esta en la posicion 0 de la lista
         * a la variable integer.
         */
        Integer integer = productos.get(0);
        /*
         * remover el entero obtenido por la lista de modo que
         * no siempre nos devuelva el mismo valor.
         */
        productos.remove(integer);
        return integer;
    }

    public synchronized void setProducto(Integer producto) {
        /*
         * agregar a la lista el entero recibido por parametro.
         */
        this.productos.add(producto);
        /*
         * Notificar al posible hilo que esta en wait que ya puede continuar.
         */
        notify();
    }

    public synchronized void cerrarAlmacen() {
        notifyAll();
    }
}
