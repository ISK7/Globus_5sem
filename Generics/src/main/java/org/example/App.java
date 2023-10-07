package org.example;

import kiselev.task.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Stack<Integer> s = new Stack<Integer>(5);
        //System.out.println(s.get()); ArrayIndexOutOfBoundsException
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);
        System.out.println(s.pop());
        System.out.println(s.get());
    }
}
