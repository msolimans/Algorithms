package com.designpattern.Creational.Singleton;

/**
 * Created by msoliman on 1/31/17.
 */
public class SingletonImp {
    private SingletonImp(){}

    private  static SingletonImp impl ;


    public  static synchronized SingletonImp getInstance(){

        if (impl == null)
            impl = new SingletonImp();


        return impl;

    }

}
