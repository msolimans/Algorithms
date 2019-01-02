package com.designpattern.Creational.Singleton;

/**
 * Created by msoliman on 5/8/17.
 */
public class DBManagerV2 {

    private static DBConnection dbConnection;


    public static synchronized DBConnection getDbConnection(){
        if(dbConnection == null)
            dbConnection = new DBConnection();

        return dbConnection;

    }



}
