/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf19;

/**
 *
 * @author curso1
 */
public class QR_ENUMS {

    public enum Dias {

        Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo
    }
    
    public enum Dias01 {

        Lunes(16), Martes(1), Miercoles(2), Jueves(3), Viernes(4), Sabado(5), Domingo(6);
        int dia;

        private Dias01(int d) {
            dia = d;
        }

        public int getDia() {
            return dia;
        }
    }

    public void QR_Constantes() {
        int day = 2;
        switch (day) {
            case QR_Constants._Lunes:
                System.out.println("Lunes");
            case QR_Constants._Martes:
                System.out.println("Martes");
                break;
            case QR_Constants._Miercoles:
                System.out.println("Miercoles");
            case QR_Constants._Jueves:
                System.out.println("Jueves");
            case QR_Constants._Viernes:
                System.out.println("Viernes");
            case QR_Constants._Sabado:
                System.out.println("Sabado");
            case QR_Constants._Domingo:
                System.out.println("Domingo");
        }
    }

    public void QR_Enum() {
        Dias day = Dias.Lunes;
        day.compareTo(day);
        System.out.println(Dias.valueOf("Martes"));
    }

    public void QR_Enum01() {
        Dias01 day = Dias01.Martes;
        System.out.println(day.getDia());
    }

    public static void main(String[] p) {
        QR_ENUMS con = new QR_ENUMS();
        con.QR_Enum();
    }
}
