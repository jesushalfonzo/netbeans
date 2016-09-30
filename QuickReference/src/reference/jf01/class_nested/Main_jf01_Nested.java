/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf01.class_nested;

/**
 *
 * @author yech
 */
public class Main_jf01_Nested {
    public static void main(String [] p){
        // Crear objeto de una static nested class.
        OuterClass.NestedClass snc = new OuterClass.NestedClass();
        // Crear un objeto de una InnerClass.
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass ic = oc.new InnerClass();
    }
}
