/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf01.class_anonymous;

/**
 *
 * @author yecheverria
 */
public class Anonymous {
    /*
     Una clase anonima siempre es creada desde una Interfaz.
     La clases anonima se crea con la palabra new + el nombre de una Interfaz:
     new InterfaceName(){...
     La clase anonima DEBE dar "cuerpo" a todos los metodos de la Interfaz.
     */
    private FigurasGeometricasInterface cuadrado = new Cuadrado();
    
    private FigurasGeometricasInterface cuadradoAnonimo = new FigurasGeometricasInterface() {

        @Override
        public float calcularArea() {
            return 2 * 2;
        }

        @Override
        public void dibujame() {
            System.out.println("Dibujando un cuadrado");
        }
    };

    private FigurasGeometricasInterface rectanguloAnonimo = new FigurasGeometricasInterface() {

        @Override
        public float calcularArea() {
            return 3 * 5;
        }

        @Override
        public void dibujame() {
            System.out.println("Dibujando un rectangulo");
        }
    };

    public FigurasGeometricasInterface getCuadrado() {
        return cuadrado;
    }

    public void setCuadrado(FigurasGeometricasInterface cuadrado) {
        this.cuadrado = cuadrado;
    }

    public FigurasGeometricasInterface getCuadradoAnonimo() {
        return cuadradoAnonimo;
    }

    public void setCuadradoAnonimo(FigurasGeometricasInterface cuadradoAnonimo) {
        this.cuadradoAnonimo = cuadradoAnonimo;
    }

    public FigurasGeometricasInterface getRectanguloAnonimo() {
        return rectanguloAnonimo;
    }

    public void setRectanguloAnonimo(FigurasGeometricasInterface rectanguloAnonimo) {
        this.rectanguloAnonimo = rectanguloAnonimo;
    }

    public static void main(String[] p) {
        Anonymous a = new Anonymous();
        System.out.println("cuadrado: " + a.getCuadrado().calcularArea());
        System.out.println("rectangulo: " + a.getRectanguloAnonimo().calcularArea());
    }
}
