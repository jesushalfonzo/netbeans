/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf19.example01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author yecheverria
 */
public class QueueTest {
    static Queue<String> q = new ArrayDeque<>();
    
    public static void main(String [] p){
        q.add("3Techo");
        q.add("1palabra");
        q.add("2hola");
        q.add("3null");
        q.add("nulo");
        for (String palabra : q) {
            System.out.println("->" + q.remove());
        }
    }
    
}
