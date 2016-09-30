/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author curso1
 */
public class Estructuras {

    public void QR_switch(int sw) {
        switch (sw) {
            case 1:
                System.out.println("Hacer algo 1");
                break;
            case 2:
            case 3:
                System.out.println("Hacer algo si es 2 o 3");
                break;
            case 4:
                System.out.println("Hacer algo si es 4");
            case 5:
                System.out.println("Hacer algo si es 5");
                break;
            default:
                System.out.println("Hacer algo si es default");
        }
    }

    public void QR_for(int fr) {
        for (int i = 0; i < fr; i++) {
            System.out.println(i + ", ");
        }
    }

    public void QR_while(int wh) {
        int i = 0;
        while (i < wh) {
            i++;
            System.out.println("en el ciclo " + i);
        }
        System.out.println("sali");
    }

    public void QR_doWhile(int d) {
        int i = 0;
        do {
            i++;
            System.out.println("en el ciclo " + i);
        } while (i < d);
        System.out.println("sali");
    }
    
    public void QR_forCollectionList(){
        List<String> listString = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();
        
        listString.add("algo uno");
        listString.add("algo");
        listString.add("tres");
        listInteger.add(1);
        listInteger.add(4);
        listInteger.add(2);
        
        for (int i=0; i< listString.size(); i++){
            System.out.println("valor for:" + listString.get(i));
        }
        
        for (String list1 : listString) {
            System.out.println("collection: " + list1);
        }
        
        for (Integer listInteger1 : listInteger) {
            System.out.println("collection: " + listInteger1);
        }
    }
    
    public void QR_setCollection(){
        Set<String> setString = new HashSet<>();
        Set<Integer> setInteger = new HashSet<>();
        
        setString.add("v1");
        setString.add("v2");
        setString.add("v3");
        
        for (String nombre : setString) {
            System.out.println(nombre);
        }
        
        setInteger.add(1);
        setInteger.add(2);
        setInteger.add(5);
        
        for (Integer pos : setInteger) {
            System.out.println(pos);
        }
    }

    public static void main(String[] p) {
        Estructuras e = new Estructuras();
//        e.QR_doWhile(4);
//        e.QR_for(6);
//        e.QR_switch(3);
//        e.QR_while(7);
//        e.QR_forCollectionList();
        e.QR_setCollection();
    }
}
