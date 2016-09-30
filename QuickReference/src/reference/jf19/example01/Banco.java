/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf19.example01;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yecheverria
 */
public class Banco {

    int contCajero;
    int contCadivi;
    int contApertura;

    public static enum Servicio {

        Cajero(1, 100), Cadivi(200, 400), Apertura(500, 600);
        int min, max;

        private Servicio(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

    }

    Map<Servicio, Map<Integer, Persona>> mapTicket = new HashMap<>();
    Map<Integer, Persona> mapPerson = new HashMap<>();

    public Banco() {
        contCajero = Servicio.Cajero.getMin();
        contCadivi = Servicio.Cadivi.getMin();
        contApertura = Servicio.Apertura.getMin();
        for (Servicio servicio : Servicio.values()) {
            mapTicket.put(servicio, new HashMap<Integer, Persona>());
        }
    }

    public int getNumTicket(Servicio servicio, Persona persona) {

        mapPerson = mapTicket.get(servicio);
        if (servicio.equals(Servicio.Apertura)) {
            if (contApertura < servicio.getMax()) {
                contApertura++;
            } else if (contApertura == servicio.getMax()) {
                contApertura = servicio.getMin();
            }
            mapPerson.put(contApertura, persona);
            mapTicket.put(servicio, mapPerson);
            return contApertura;
        } else if (servicio.equals(Servicio.Cadivi)) {
            if (contCadivi < servicio.getMax()) {
                contCadivi++;
            } else if (contCadivi == servicio.getMax()) {
                contCadivi = servicio.getMin();
            }
            mapPerson.put(contCadivi, persona);
            mapTicket.put(servicio, mapPerson);
            return contCadivi;
        } else {
            if (contCajero < servicio.getMax()) {
                contCajero++;
            } else if (contCajero == servicio.getMax()) {
                contCajero = servicio.getMin();
            }
            mapPerson.put(contCajero, persona);
            mapTicket.put(servicio, mapPerson);
            return contCajero;
        }
    }

    public void callNumTicket(Servicio servicio) {

        Map<Integer, Persona> map = mapTicket.get(servicio);
        int numToCall = 100000000;

        for (Map.Entry<Integer, Persona> entrySet : map.entrySet()) {
            Integer key = entrySet.getKey();
//            System.out.println(servicio + "->key->" + key);
            if (numToCall > key) {
                numToCall = key;
            }
        }

        Persona p = map.remove(numToCall);
        System.out.println("Llamando al num " + numToCall + " de " + p.getName());
    }

    public static void main(String[] args) {
        Banco b = new Banco();
        Persona p = new Persona("Pepito", "De Pollo", 78572342);

        for (int i = 0; i < 20; i++) {
            System.out.println("Cadivi->: " + b.getNumTicket(Banco.Servicio.Cadivi, p));
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("Cajero->: " + b.getNumTicket(Banco.Servicio.Cajero, p));
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("Apertura->: " + b.getNumTicket(Banco.Servicio.Apertura, p));
        }

        System.out.println("Cadivi: ");
        for (int i = 0; i < 10; i++) {
            b.callNumTicket(Banco.Servicio.Cadivi);
        }

        System.out.println("Cajero: ");
        for (int i = 0; i < 10; i++) {
            b.callNumTicket(Banco.Servicio.Cajero);
        }

        System.out.println("Apertura: ");
        for (int i = 0; i < 10; i++) {
            b.callNumTicket(Banco.Servicio.Apertura);
        }
    }
}
