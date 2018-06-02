package com.acka.learn.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDao<T> {

    //Protected
    protected final String tableName;
    protected Connection connection;
    protected GenericDao(Connection connection, String tableName) {
        this.tableName = tableName;
        this.connection = connection;
    }

    public abstract int count() throws SQLException;

    public abstract void create();

    public abstract void retreive();

    public abstract void update();

    public abstract void delete();

}
