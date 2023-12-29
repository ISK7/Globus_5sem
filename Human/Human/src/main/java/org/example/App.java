package org.example;

import kiselev.human.Human;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Human me = new Human(2003, true, "Igor", "Kiselev", "Sergeevich");
        me.outInfo();
    }
}
