package com.lincode;

/**
 * Created by msoliman on 2/16/17.
 */
public class Singleton {

    private Singleton(){}
    private static Singleton singleton;

    public static Singleton getInstance(){

        if(singleton == null)
            singleton = new Singleton();

        return singleton;
    }

    public static void main(String[] s){
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        System.out.print( a == b);
    }
}
