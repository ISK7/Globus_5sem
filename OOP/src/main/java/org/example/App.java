package org.example;

import kiselev.task.Class;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Class cl = new Class(1, 2, 3);
        cl.printA();
        cl.printB();
        cl.printC();
        cl.setA(4);
        cl.printA();
    }
}
