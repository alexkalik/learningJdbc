package com.acka.learn.jdbc.dao;

import com.acka.learn.jdbc.db.DerbyConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoManager {

    private static final ThreadLocal<DaoManager> threadLocalDaoManager =
            ThreadLocal.withInitial( () -> new DaoManager() );
    //Private
    private DataSource dataSource;
    private Connection connection;

        private DaoManager() {
        dataSource=DerbyConnection.getInstance();
    }

    public static DaoManager getInstance() {
        return threadLocalDaoManager.get();
    }

    public void open() throws SQLException {
        try
        {
            if(this.connection==null || this.connection.isClosed())
                this.connection = dataSource.getConnection();
                this.connection.setAutoCommit(false);
        }
        catch(SQLException e) { throw e; }
    }

    public void close() throws SQLException {
        try
        {
            if(this.connection!=null && !this.connection.isClosed())
                this.connection.close();
        }
        catch(SQLException e) { throw e; }
    }

    public void commit() throws SQLException {
        try
        {
            if(this.connection!=null && !this.connection.isClosed())
                this.connection.commit();
        }
        catch(SQLException e) { throw e; }
    }

    public void rollback() throws SQLException {
        try
        {
            if(this.connection!=null && !this.connection.isClosed())
                this.connection.rollback();
        }
        catch(SQLException e) { throw e; }
    }

    public GenericDao getDAO(table t) throws SQLException
    {

        try
        {
            if(this.connection == null || this.connection.isClosed()) //Let's ensure our connection is open
                this.open();
        }
        catch(SQLException e){ throw e; }

        switch(t)
        {
            case COFFEES:
                return new CoffeesDao(this.connection);
            default:
                throw new SQLException("Trying to link to an unexistant table.");
        }

    }

public enum table { COFFEES }

}
