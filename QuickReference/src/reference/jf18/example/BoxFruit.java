/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf18.example;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yecheverria
 * @param <T>
 */
public class BoxFruit<T extends Fruit> {
    Map<T, Integer> mapCont = new HashMap<>();
    
    public void addFruit(T fruit){
        Integer cantFruit = 1;
        if (mapCont.containsKey(fruit)){
            cantFruit = mapCont.get(fruit);
            cantFruit++;
        }
        mapCont.put(fruit, cantFruit);
    }
    
    public void removeFruit(T fruit){
        
    }
    
    public int countFruit(T fruit){
        return mapCont.get(fruit);
    }
    
    public void printData(){
        
    }
}
