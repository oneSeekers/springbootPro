package com.demo.repository.common.db;

import com.google.common.collect.Maps;
import org.springframework.boot.bind.RelaxedPropertyResolver;

import java.util.Map;

/**
 * @author zuochi
 * @version 1.0.0
 * @date 17/8/16
 */

public class JdbcXConfig {
    public static final String DB_MASTER_URL = "master.url";
    public static final String DB_MASTER_USERNAME = "master.username";
    public static final String DB_MASTER_PASSWORD = "master.password";
    public static final String DB_MASTER_NAME = "master.name";

    public static final String DB_SLAVE_URL = "slave.url";
    public static final String DB_SLAVE_USERNAME = "slave.username";
    public static final String DB_SLAVE_PASSWORD = "slave.password";
    public static final String DB_SLAVE_NAME = "slave.name";

    public static final String DB_INITIAL_SIZE = "datasource.initalSize";
    public static final String DB_MIN_IDLE = "datasource.minIdle";
    public static final String DB_MAX_ACTIVE = "datasource.maxActive";
    public static final String DB_TEST_ON_BORROW = "datasource.testOnBorrow";
    public static final String DB_FILTERS = "datasource.filters";
    public static final String DB_JDBC_DRIVER_NAME = "datasource.driverClass";
    public static final String DB_TYPE = "datasource.type";


    private Map<String,String> master = Maps.newHashMap();
    private Map<String,String> slave = Maps.newHashMap();
    private Map<String,String> datasource = Maps.newHashMap();


    public JdbcXConfig(RelaxedPropertyResolver resolver) {

        master.put(DB_MASTER_URL,resolver.getProperty(DB_MASTER_URL));
        master.put(DB_MASTER_USERNAME,resolver.getProperty(DB_MASTER_USERNAME));
        master.put(DB_MASTER_NAME,resolver.getProperty(DB_MASTER_NAME));
        master.put(DB_MASTER_PASSWORD,resolver.getProperty(DB_MASTER_PASSWORD));

        slave.put(DB_SLAVE_URL,resolver.getProperty(DB_SLAVE_URL));
        slave.put(DB_SLAVE_USERNAME,resolver.getProperty(DB_SLAVE_USERNAME));
        slave.put(DB_SLAVE_NAME,resolver.getProperty(DB_SLAVE_NAME));
        slave.put(DB_SLAVE_PASSWORD,resolver.getProperty(DB_SLAVE_PASSWORD));

        datasource.put(DB_INITIAL_SIZE,resolver.getProperty(DB_INITIAL_SIZE));
        datasource.put(DB_MIN_IDLE,resolver.getProperty(DB_MIN_IDLE));
        datasource.put(DB_MAX_ACTIVE,resolver.getProperty(DB_MAX_ACTIVE));
        datasource.put(DB_TEST_ON_BORROW,resolver.getProperty(DB_TEST_ON_BORROW));
        datasource.put(DB_FILTERS,resolver.getProperty(DB_FILTERS));
        datasource.put(DB_JDBC_DRIVER_NAME,resolver.getProperty(DB_JDBC_DRIVER_NAME));
        datasource.put(DB_TYPE,resolver.getProperty(DB_TYPE));

    }


    public String getMasterURL() {
        return master.get(DB_MASTER_URL);
    }

    public String getMasterName() {
        return master.get(DB_MASTER_NAME);
    }

    public String getSlaveName() {
        return slave.get(DB_SLAVE_NAME);
    }

    public String getSlaveURL() {
        return slave.get(DB_SLAVE_URL);
    }

    public String getMasterUserName() {
        return master.get(DB_MASTER_USERNAME);
    }

    public String getSlaveUsername() {
        return slave.get(DB_SLAVE_USERNAME);
    }

    public String getMasterPassword() {
        return master.get(DB_MASTER_PASSWORD);
    }

    public String getSlavePassword() {
        return slave.get(DB_SLAVE_PASSWORD);
    }

    public String getDbInitialSize() {
        return datasource.get(DB_INITIAL_SIZE);
    }

    public String getDbMinIdle() {
        return datasource.get(DB_MIN_IDLE);
    }

    public String getDbMaxActive() {
        return datasource.get(DB_MAX_ACTIVE);
    }

    public String getDbTestOnBorrow() {
        return datasource.get(DB_TEST_ON_BORROW);
    }

    public String getDbFilters() {
        return datasource.get(DB_FILTERS);
    }

    public String getDbJdbcDriverName() {
        return datasource.get(DB_JDBC_DRIVER_NAME);
    }

    public String getDbType() {
        return datasource.get(DB_TYPE);
    }
}
