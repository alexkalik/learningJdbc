package com.acka.learn.jdbc.db;

import javax.sql.DataSource;

public class DerbyConnection extends ConnectionPool{
    private static volatile DataSource dataSource = null;
    private static volatile ConnectionPool connectionPool = null;

    private static String JDBC_DRIVE = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String JDBC_DB_URL = "jdbc:derby:testdb;create=true;";
    private static String JDBC_DB_USER = "";
    private static String JDBC_DB_PW = "";

    private DerbyConnection () {

    }

    public static synchronized DataSource getInstance () {
        if (dataSource == null) {
                if (dataSource == null ) {
                    dataSource = setUpDataSource();
                    return dataSource;
                }
        }

        return dataSource;
    }

    public static DataSource setUpDataSource () {
        try {
            Class.forName(JDBC_DRIVE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connectionPool = new ConnectionPool();
        DataSource dataSource = connectionPool.setUpDataSource(JDBC_DB_URL);
        return dataSource;
    }

    public static void poolAlive () {
        if (connectionPool != null) {
            connectionPool.printAlive();
        } else {
            System.out.println("No onw alive");
        }
    }

}
