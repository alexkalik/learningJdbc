package com.acka.learn.jdbc.db;

import javax.sql.DataSource;

public class DerbyConnection {
    private static volatile DataSource dataSource = null;
    private static String JDBC_DRIVE = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String JDBC_DB_URL = "jdbc:derby:testdb;create=true;";
    private static String JDBC_DB_USER = "";
    private static String JDBC_DB_PW = "";

    private DerbyConnection () {

    }

    public static DataSource getInstance () {
        if (dataSource == null) {
            synchronized(dataSource){
                if (dataSource == null ) {
                    return setUpDataSource();
                }
            }
        }

        return dataSource;
    }

    private static DataSource setUpDataSource () {
        try {
            Class.forName(JDBC_DRIVE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DataSource dataSource = ConnectionPool.setUpDataSource(JDBC_DB_URL);

        System.out.println("Done.");
        return dataSource;
    }

}
