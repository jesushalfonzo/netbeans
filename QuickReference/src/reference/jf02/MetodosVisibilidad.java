/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf02;

/**
 *
 * @author yecheverria
 */
public class MetodosVisibilidad extends Animales{
    
    
    

    @Override
    public void metodoPublico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void metodoProtected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void metodoPackage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] p){
        MetodosVisibilidad m = new MetodosVisibilidad();
    }
    
}
