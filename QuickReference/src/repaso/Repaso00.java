/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author curso4
 */
public class Repaso00 {

    List<Integer> lista = new ArrayList<>();

    public void metodo1() {
        lista.add(2);
        lista.add(4);
        lista.add(5);
        lista.add(7);
        for (Integer integer : lista) {
            System.out.println(integer);
        }
        lista.remove(new Integer(7));
        for (Integer integer : lista) {
            System.out.println(integer);
        }
    }

    public void metodo2(int casa) {
    }

    public String met3() {

        return "hola";
    }

    public int met4(int rosa) {
        rosa = rosa + 2;
        return rosa;

    }
}
