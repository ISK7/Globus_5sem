package org.example;
import kiselev.task.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Queue<String> Patients = new Queue<>();
        Patients.add("Lupa");
        Patients.add("Pupa");
        Patients.add("Biba");
        Patients.add("Boba");
        System.out.println(Patients.getLast());
        System.out.println(Patients.contains("Biba"));
        System.out.println(Patients.addAfter("Biba","Aboba"));
        System.out.println(Patients.getFirst());
        System.out.println(Patients.popFirst());
        System.out.println(Patients.popFirst());
        System.out.println(Patients.popFirst());
        System.out.println(Patients.popFirst());
        System.out.println(Patients.popFirst());
    }
}
