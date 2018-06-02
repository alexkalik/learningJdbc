package com.acka.learn.jdbc.db;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.sql.DataSource;

class ConnectionPool {

    static DataSource setUpDataSource(String connectURI) {

        ObjectName test = null;

        //ConnectionFactory that the pool will use to create Connections.
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(connectURI,"" ,"");

        //PoolableConnectionFactory wraps the "real" connection created by the ConnectionFactory
        //with the classes that implement the pooling functionality
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);

        //ObjectPool that serves as the actual pool of connections
        ObjectPool<PoolableConnection> connectionPool;
        connectionPool = new GenericObjectPool<>(poolableConnectionFactory);
        ((GenericObjectPool<PoolableConnection>) connectionPool).setMaxTotal(100);

        // Set the factory's pool property to the owning pool
        poolableConnectionFactory.setPool(connectionPool);

        //Create the PoolingDriver itself passing in the object pool we created
        PoolingDataSource<PoolableConnection> dataSource =  new PoolingDataSource<>(connectionPool);

        return dataSource;
    }


}
