/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.beans.Employee;

/**
 *
 * @author curso1
 */
public class Example01 {

    List<Employee> odontologo = new ArrayList<>();
    /*
     * Crear un map que tenga como key un Entero y como
     * valor una lista de Odontologos.
     */
    Map<Integer, List<Employee>> citas = new HashMap<>();

    public Example01() {
        test01();
    }

    private void test01() {
        /*
         * Incluir odontogolos: Emula los datos que estan en un comboBox
         * Este List es fijo, es decir, no agrego ni borro algo de aqui.
         */
        odontologo.add(new Employee(12345, "Nombre01", "Cargo01"));
        odontologo.add(new Employee(12346, "Nombre02", "Cargo02"));
        odontologo.add(new Employee(12347, "Nombre03", "Cargo03"));
        odontologo.add(new Employee(12348, "Nombre04", "Cargo04"));
        odontologo.add(new Employee(12349, "Nombre05", "Cargo05"));
        /*
         * Incluir citas
         * hora - odontologo
         */
        addCita(1, odontologo.get(0));
        addCita(2, odontologo.get(0));
        addCita(3, odontologo.get(0));
        addCita(4, odontologo.get(0));
        addCita(5, odontologo.get(0));
        addCita(1, odontologo.get(0));
        addCita(6, odontologo.get(0));
        addCita(1, odontologo.get(1));
        addCita(1, odontologo.get(2));
        addCita(1, odontologo.get(3));
        addCita(1, odontologo.get(4));
        addCita(2, odontologo.get(0));
        addCita(3, odontologo.get(4));
        addCita(4, odontologo.get(3));
        addCita(5, odontologo.get(2));
        addCita(1, odontologo.get(1));
        addCita(6, odontologo.get(4));
        addCita(1, odontologo.get(3));
        addCita(1, odontologo.get(3));
        addCita(1, odontologo.get(3));
    }

    /*
     * Incluir Citas
     * hora: hora de la cita
     * odontogolo: el odontologo
     */
    private boolean addCita(Integer hora, Employee odontologo) {
        /*
         * utilizo esta variable para saber si se encontro
         * o no una cita establecida para el odontologo.
         */
        boolean appointmentFound = false;
        /*
         * Este List representa los odontologos con citass.
         */
        List<Employee> aOdonConCita;

        /*
         * pregunto si ya tengo guardada una Lista de 
         * odontologos para la hora enviada por parametro.
         */
        if (citas.containsKey(hora)) {
            /*
             * Obtengo la lista de odontologos con citas a esa hora
             */
            aOdonConCita = citas.get(hora);
            /*
             * Recorro la Lista de odontologos
             */
            for (Employee odonConCIta : aOdonConCita) {
                /*
                 * Si la Cedula de un odontologo guardado es igual a la
                 * cedula del odontologo enviado por parametro significa que ya
                 * tiene una cita para esa hora.
                 */
                if (odontologo.getId() == odonConCIta.getId()) {
                    /*
                     * Indico que se encontro una cita para el odontologo
                     * enviado por parametro.
                     */
                    appointmentFound = true;
                    /*
                     * me salgo del ciclo for para evitar que siga el recorrido
                     */
                    break;
                }
            }
            /*
             * si la cita no existe.
             */
            if (!appointmentFound) {
                /*
                 * Guardo al odontolgo enviado por parametro  en la lista
                 * de odontologos con citas a esa hora.
                 */
                aOdonConCita.add(odontologo);
                /*
                 * Sobre escribo el valor de la lista actual en el Map con 
                 * la lista donde agregue el nuevo odontologo. Sobreescribo porque
                 * estoy guardando la lista en una hora(key) ya existente.
                 */
                citas.put(hora, aOdonConCita);
                System.out.println("Cita creada exitosamente!!:" + hora + " " + odontologo.getName());
                return true;
            }
        }
        /*
         * Si encontre una cita.
         */
        if (appointmentFound) {
            System.out.println("Cita existente para este odontologo: " + hora + " - " + odontologo.getName());
            return false;
        }
        /*
         * Al llegar a este punto la hora enviada por parametro
         * no tenia Lista con odontolgos, asi que, cree se creo una
         * nueva lista, se agrego al odontologo enviado por parametro y
         * se guardo en el Map.
         */
        aOdonConCita = new ArrayList<>();
        /*
         * Agregar el odontologo a la lista de odontologos con cita a la hora
         */
        aOdonConCita.add(odontologo);
        /*
         * Crear en el Map la cita con la hora y la lista de odontologos que
         * hasta este instante tiene uno solo porque esta recien creada.
         */
        citas.put(hora, aOdonConCita);
        System.out.println("Cita creada exitosamente!!:" + hora + " " + odontologo.getName());
        return true;
    }

    public static void main(String[] p) {
        new Example01();
    }
}
