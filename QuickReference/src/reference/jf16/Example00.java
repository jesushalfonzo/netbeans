/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.beans.Ciudadano;

/**
 *
 * @author curso1
 */
public class Example00 {

    Ciudadano ciudadano;
    List<Ciudadano> aCiudadanos = new ArrayList<>();
    List<Ciudadano> aCiudadanos2 = new ArrayList<>();
    Map<Integer, List<Ciudadano>> map = new HashMap<>();

    public void test01() {
        /*
         * Guardar ciudadanos en la lista.
         */
        ciudadano = new Ciudadano(123, "Uno");
        aCiudadanos.add(ciudadano);
        ciudadano = new Ciudadano(124, "Dos");
        aCiudadanos.add(ciudadano);
        ciudadano = new Ciudadano(125, "Tres");
        aCiudadanos.add(ciudadano);
        ciudadano = new Ciudadano(126, "Cuatro");
        aCiudadanos.add(ciudadano);
        ciudadano = new Ciudadano(127, "Cinco");
        aCiudadanos.add(ciudadano);


        /*
         * Agregar con el key = 3 un List con los ciudadanos
         * añadidos anteriormente.
         */
        map.put(3, aCiudadanos);
        /*
         * recorrer el Map.
         */
        for (Map.Entry<Integer, List<Ciudadano>> entry : map.entrySet()) {
            /*
             * Obtener el Key de la poscicion actual del Map, que en este caso
             * es un Entero.
             */
            Integer key = entry.getKey();
            /*
             * Obtener el Value de la posicion actual, que en este caso
             * es una Lista de Ciudadanos.
             */
            List<Ciudadano> ciudadanos = entry.getValue();
            System.out.println(key + "=>");
            /*
             * Recorrer el List de Ciudadanos devueltos por el Map.
             */
            for (Ciudadano ciudadano1 : ciudadanos) {
                System.out.println(ciudadano1.getName());
            }
        }
    }

    public static void main(String[] p) {
        Example00 example00 = new Example00();
        example00.test01();
    }
}
