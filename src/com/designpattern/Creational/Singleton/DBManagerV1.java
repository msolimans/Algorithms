package com.designpattern.Creational.Singleton;


/**
 * Created by msoliman on 5/8/17.
 */
public class DBManagerV1 {


    private static DBConnection dbConnection = new DBConnection();

    public static DBConnection getInstance(){
        return dbConnection;
    }




}
