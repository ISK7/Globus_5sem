package org.example;

import kiselev.task.Caller;
import kiselev.task.C;
import kiselev.task.B;
import kiselev.task.A;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Caller caller = new Caller();
        A a = new A();
        B b = new B();
        C c = new C();
        caller.call(a);
        caller.call(b);
        caller.call(c);
    }
}
