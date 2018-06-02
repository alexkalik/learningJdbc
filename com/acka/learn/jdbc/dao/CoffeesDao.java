package com.acka.learn.jdbc.dao;

import com.acka.learn.jdbc.dao.entityObject.Coffees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.apache.derby.iapi.services.locks.VirtualLockTable.TABLENAME;

public class CoffeesDao extends GenericDao<Coffees> {

    public CoffeesDao(Connection connection) {
        super(connection, TABLENAME);
    }

    @Override
    public int count() {
        int count = 0;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM COFFEES";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            int numcols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
        return count;
    }

    @Override
    public void create() {
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "create table COFFEES" +
                " (COF_NAME varchar(32) NOT NULL," +
                " SUP_ID varchar(32) NOT NULL," +
                " PRICE varchar(32) NOT NULL," +
                " SALES varchar(32) NOT NULL," +
                " TOTAL varchar(32) NOT NULL," +
                " PRIMARY KEY (COF_NAME))";
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            System.out.println("Results:");
            int numcols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i=0; i<=numcols; i++) {
                    System.out.print("\t" + rs.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }

    @Override
    public void retreive() {
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM COFFEES";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("select record in given database...");
            System.out.println("Results:");
            int numcols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                System.out.print("\t" + rs.getString(1));
                System.out.print("\t" + rs.getString(2));
                System.out.print("\t" + rs.getString(3));
                System.out.print("\t" + rs.getString(4));
                System.out.print("\t" + rs.getString(5));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }

    }

    @Override
    public void update() {
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "UPDATE COFFEES " +
                "SET SUP_ID = '400000'";
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("update record in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }

    @Override
    public void delete() {
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "DELETE FROM COFFEES " +
                "WHERE COF_NAME = 'HELLO'";
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("update record in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }
}
