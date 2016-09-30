/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf18.example;

/**
 *
 * @author yecheverria
 */
public class MainFruit {
    
    public static void main(String [] p ){
        
        BoxFruit<Fruit> box = new BoxFruit<>();
        Mango mango1 = new Mango();
        Mango mango = new Mango();
        Pera pera = new Pera();
        Fresa fresa = new Fresa();
        
        box.addFruit(mango1);
        box.addFruit(mango);
        box.addFruit(fresa);
        box.addFruit(fresa);
        box.addFruit(fresa);
        box.addFruit(fresa);
        box.addFruit(fresa);
        box.addFruit(pera);
        
        System.out.println("Mango: " + box.countFruit(mango));
        System.out.println("fresa: " + box.countFruit(fresa));
        System.out.println("pera: " + box.countFruit(pera));
    }
    
}
