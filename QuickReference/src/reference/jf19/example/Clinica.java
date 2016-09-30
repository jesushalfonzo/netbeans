/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf19.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yecheverria
 */
public class Clinica {

    public static int _Odontologia_Max = 5;

    public enum Departamentos {

        Odontologia(5), Traumatologia(7), Medicina_General(3), Ginecologia(2), Homeopatia(2);
        int max;

        private Departamentos(int max) {
            this.max = max;
        }

        public int getMax() {
            return max;
        }
    }

    public enum sex {

        male, female;
    }

    /*
     Map que voy a utilizar para contar las citas de los departamentos.
     */
    Map<Departamentos, Integer> mapCounter = new HashMap<>();

    /*
     Map que utilizo para guardar un list de personas por departamento.
     */
    Map<Departamentos, List<Person>> mapPerson = new HashMap<>();

    public Clinica() {
        /*
         Ciclo para inicializar las listas de las personas por departamentos.
         */
        for (Departamentos va : Departamentos.values()) {
            mapPerson.put(va, new ArrayList<Person>());
        }
    }

    public boolean addDate(Departamentos dep, Person person) {
        List<Person> listPerson = mapPerson.get(dep);
        int sizeAct = listPerson.size();
        /*
         No aceptar citas de hombres en ginecologia.
         */
        if (dep.equals(Departamentos.Ginecologia) && person.getSex() == sex.male) {
            return false;
        }
        /*
         Validar maximo de citas y que no tenga una cita previa.
         */
        if (sizeAct < dep.getMax() && !listPerson.contains(person)) {
            listPerson.add(person);
            mapPerson.put(dep, listPerson);
            return true;
        }
        return false;
    }

    public boolean removeDate(Departamentos dep, Person person) {
        List<Person> listPerson = mapPerson.get(dep);
        boolean isDeleted = listPerson.remove(person);
        if (isDeleted) {
            mapPerson.put(dep, listPerson);
        }
        return isDeleted;
    }

    public void print() {
        for (Map.Entry<Departamentos, List<Person>> entrySet : mapPerson.entrySet()) {
            Departamentos dep = entrySet.getKey();
            List<Person> listPersons = entrySet.getValue();
            /*
             Imprimir solo aquellos departamentos que tienen personas.
             */
            if (!listPersons.isEmpty()) {
                System.out.println("Departamento " + dep);
                for (Person value1 : listPersons) {
                    System.out.println("nombre " + value1.getName());
                }
            }

        }
    }

    public void print(Departamentos dep) {
        List<Person> listPerson = mapPerson.get(dep);
        if (listPerson.isEmpty()) {
            System.out.println("El departamento " + dep + " no tiene cita");
            return;
        }
        System.out.println("El departamento: " + dep);
        for (Person person : listPerson) {
            System.out.println("Person: " + person.getName() + " " + person.getLastName());
        }

    }

    public static void main(String[] p) {
        Clinica c = new Clinica();
        Person person = new Person("yermi", "Echeverria", 123456789, sex.male);
//        c.addDate(Departamentos.Homeopatia, person);
//        c.addDate(Departamentos.Homeopatia, person);
//        c.addDate(Departamentos.Homeopatia, person);
//        c.addDate(Departamentos.Homeopatia, person);
//        c.addDate(Departamentos.Homeopatia, person);
//        c.addDate(Departamentos.Homeopatia, person);
//        c.addDate(Departamentos.Medicina_General, person);
//        c.addDate(Departamentos.Medicina_General, person);
        c.addDate(Departamentos.Medicina_General, person);
        c.addDate(Departamentos.Ginecologia, person);
        c.print(Departamentos.Medicina_General);
           c.print(Departamentos.Homeopatia);
    }
}
