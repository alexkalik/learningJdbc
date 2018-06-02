package com.acka.learn.jdbc;

import com.acka.learn.jdbc.dao.DaoManager;
import com.acka.learn.jdbc.dao.GenericDao;
import com.acka.learn.jdbc.db.DerbyConnection;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 1; i < 100; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    DaoManager daoManager = DaoManager.getInstance();
                    try {
                        daoManager.open();
                        retreiveCoffee(daoManager);
                        daoManager.commit();
                        daoManager.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        try {
            while (true) {
                sleep(1000);
                System.out.println("Pool");
                DerbyConnection.poolAlive();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void retreiveCoffee(DaoManager daoManager) {
        try {
            GenericDao genericDao = daoManager.getDAO(DaoManager.table.COFFEES);
            genericDao.retreive();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCoffee(DaoManager daoManager) {
        try {
            GenericDao genericDao = daoManager.getDAO(DaoManager.table.COFFEES);
            genericDao.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCoffee(DaoManager daoManager) {
        try {
            GenericDao genericDao = daoManager.getDAO(DaoManager.table.COFFEES);
            genericDao.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
