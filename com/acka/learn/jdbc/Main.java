package com.acka.learn.jdbc;

import com.acka.learn.jdbc.dao.DaoManager;
import com.acka.learn.jdbc.dao.GenericDao;

import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        retreiveCoffee();
//        connectionPoolTest();
//        connectionTwoDiffPoolTest();
//        multiConnectionTest();
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//
////        Statements.selectTable();
//
//        for (int i = 1; i < 100; i++) {
//            executorService.execute(new Runnable() {
//                public void run() {
//                    Statements.selectTable();
//                }
//            });
//
//        }
//        try {
//            sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        while (true) {
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }

//        executorService.shutdown();


//        Statements.dropTable();
//        Statements.createTable();
//        Statements.insertTable();
//        Statements.selectTable();
    }

    public static void retreiveCoffee() {
        DaoManager daoManager = DaoManager.getInstance();
        try {
            daoManager.open();
            GenericDao genericDao = daoManager.getDAO(DaoManager.table.COFFEES);
            genericDao.retreive();
            genericDao.retreive();
            genericDao.retreive();

            daoManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
