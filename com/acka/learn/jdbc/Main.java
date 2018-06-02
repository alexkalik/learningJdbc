package com.acka.learn.jdbc;

import com.acka.learn.jdbc.db.DerbyConnection;
import com.acka.learn.jdbc.statement.Statements;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
//        Statements.dropTable();
//        Statements.createTable();
//        Statements.insertTable();
        Statements.selectTable();
    }


}
