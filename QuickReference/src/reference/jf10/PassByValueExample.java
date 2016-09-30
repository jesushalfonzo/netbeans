/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf10;

/**
 *
 * @author yecheverria
 */
public class PassByValueExample {

    public static void main(String[] p) {
        int i = 10;
        int b = 1;
        Balloon red = new Balloon("Red");
        Balloon blue = new Balloon("Blue");
        swap(red, blue);
        System.out.println("red->" + red.getColor());
        System.out.println("blue->" + blue.getColor());
        swap(i, b);
        System.out.println("i (10)->" + i);
        System.out.println("b (1) ->" + b);
    }

    public static void swap(Balloon ob1, Balloon ob2) {
        Balloon temp = ob1;
        ob1 = ob2;
        ob2 = temp;
        temp.setColor("algo");
    }
    public static void swap(int ob1, int ob2) {
        int temp = ob1;
        ob1 = ob2+1;
        ob2 = temp;
    }

    public static class Balloon {

        private String color;

        public Balloon(String color) {
            this.color = color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }
}
