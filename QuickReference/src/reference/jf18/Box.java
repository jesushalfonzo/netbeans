/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf18;

/**
 * El tipo de "T" se va a conocer cuando se declare una variable de tipo Box.
 *
 * @param <T>
 */
public class Box<T> {

    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
