package com.acka.learn.jdbc.statement;

import com.acka.learn.jdbc.db.DerbyConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statements {
    public static void createTable () {
        DataSource ds = null;
        Connection conn;
        conn = null;
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
            ds = DerbyConnection.getInstance();
            conn = ds.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
//            System.out.println("Results:");
//            int numcols = rs.getMetaData().getColumnCount();
//            while (rs.next()) {
//                 for (int i=0; i<=numcols; i++) {
//                     System.out.print("\t" + rs.getString(i));
//                 }
//                System.out.println("");
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (conn != null) conn.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }

    public static void dropTable () {
        DataSource ds;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "drop table COFFEES" ;

        try {
            ds = DerbyConnection.getInstance();
            conn = ds.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("dropped table in given database...");
//            System.out.println("Results:");
//            int numcols = rs.getMetaData().getColumnCount();
//            while (rs.next()) {
//                 for (int i=0; i<=numcols; i++) {
//                     System.out.print("\t" + rs.getString(i));
//                 }
//                System.out.println("");
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (conn != null) conn.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }

    public static void insertTable () {
        DataSource ds = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO COFFEES " +
                "VALUES ('ALI', '1', '2', '3', '4')";

        try {
            ds = DerbyConnection.getInstance();
            conn = ds.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Insert record in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (conn != null) conn.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }

    public static void selectTable () {
        DataSource ds = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM COFFEES";
        try {
            ds = DerbyConnection.getInstance();
            conn = ds.getConnection();
            stmt = conn.createStatement();
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
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (conn != null) conn.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }

    public static void updateTable () {
        DataSource ds = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "UPDATE COFFEES " +
                "SET SUP_ID = 30 WHERE COF_NAME = 'HELLO'";
        try {
            ds = DerbyConnection.getInstance();
            conn = ds.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("update record in given database...");
            System.out.println("Results:");
            int numcols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i=0; i<=numcols; i++) {
                    System.out.print("\t" + rs.getString(i));
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (conn != null) conn.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }

    public static void deleteTable () {
        DataSource ds = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "DELETE FROM COFFEES " +
                "WHERE COF_NAME = 'HELLO'";
        try {
            ds = DerbyConnection.getInstance();
            conn = ds.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("update record in given database...");
            System.out.println("Results:");
            int numcols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i=0; i<=numcols; i++) {
                    System.out.print("\t" + rs.getString(i));
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {}
            try { if (conn != null) conn.close();} catch (Exception e) {}
            try { if (stmt != null) stmt.close();} catch (Exception e) {}
        }
    }
}
