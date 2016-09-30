/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf01.class_abstract;

/*
 Para hacer una clase abstracta se coloca la palabra
abstract antes de class.

De una clase tipo abstracta NO se pueden crear objetos.

Una clase abstracta puede ser abstracta por dos razones:
1) No tiene sentido que se cree un objeto de esa clase.
2) Contiene un metodo abstracto, y al contener un metodo
abstracto la clase a juro DEBE ser abstracta.
 */
public abstract class Figuras_Geometricas {
    private float area;

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
    
    public abstract float calcularArea();
    
}
