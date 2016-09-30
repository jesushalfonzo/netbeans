/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf20;

/**
 *
 * @author curso1
 */
public class MainThread {

    public static boolean _stop = false;

    public static void main(String[] p) throws InterruptedException {
        /*
         * Declaro e instancio la Variable tipo almacen que sera comun
         * tanto para Productor como para Consumidor.
         */
        Almacen almacen = new Almacen();
        /*
         * Creo hilos tipo Productor
         */
        new Thread(new Productor(almacen)).start();
//        new Thread(new Productor(almacen)).start();
//        new Thread(new Productor(almacen)).start();
//        new Thread(new Productor(almacen)).start();
        Thread.sleep(1000);
        /*
         * Creo hilos tipo consumidor con su nombre
         */
        new Thread(new Consumidor(almacen, "h-1")).start();
        new Thread(new Consumidor(almacen, "h-2")).start();
        new Thread(new Consumidor(almacen, "h-3")).start();
        new Thread(new Consumidor(almacen, "h-4")).start();
        new Thread(new Consumidor(almacen, "h-5")).start();
        new Thread(new Consumidor(almacen, "h-6")).start();
        new Thread(new Consumidor(almacen, "h-7")).start();
        Thread.sleep(500);
        _stop = true;
        System.out.println("Sali del programa");
        /*
         * 
         * NOTA :
         *
         * Cuando se trabaja con hilos se inician con el metodo de nombre
         * .start() mas esto no significa se que va a ejecutar inmediatamente o
         * en el orden en el que fueron llamados.
         */
    }
}
