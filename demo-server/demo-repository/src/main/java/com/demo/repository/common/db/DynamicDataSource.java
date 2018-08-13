package com.demo.repository.common.db;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.demo.repository.common.db.enums.DataSourceTarget;

public class DynamicDataSource extends AbstractRoutingDataSource {

    public static String DEFAULT_DB = DataSourceTarget.MASTER.getName();

    @Override
    protected Object determineCurrentLookupKey() {
        return StringUtils.isBlank(getDataSourceType()) ? DEFAULT_DB : getDataSourceType();
    }

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
