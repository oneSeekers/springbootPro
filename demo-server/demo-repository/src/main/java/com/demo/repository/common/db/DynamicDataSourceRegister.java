package com.demo.repository.common.db;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);

    // 数据源配置信息
    private PropertyValues dataSourcePropertyValues;
    // 默认数据源
    private DataSource defaultDataSource;
    // 动态数据源
    private Map<String, DataSource> dynamicDataSources = Maps.newHashMap();

    @Override
    public void setEnvironment(Environment environment) {

        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "jdbc-router.");

        JdbcXConfig jdbcXConfig = new JdbcXConfig(propertyResolver);

        defaultDataSource = initMaterDataSource(jdbcXConfig);

        dataBinder(defaultDataSource,jdbcXConfig);

        DataSource slaveDataSource = initSlaveDataSource(jdbcXConfig);

        dataBinder(slaveDataSource,jdbcXConfig);

        dynamicDataSources.put(jdbcXConfig.getSlaveName(),slaveDataSource);

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        Map<Object, Object> targetDataSources = Maps.newHashMap();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        // 添加更多数据源
        targetDataSources.putAll(dynamicDataSources);

        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();

        beanDefinition.setBeanClass(DynamicDataSource.class);

        beanDefinition.setSynthetic(true);

        MutablePropertyValues mpv = beanDefinition.getPropertyValues();

        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);

        mpv.addPropertyValue("targetDataSources", targetDataSources);

        beanDefinitionRegistry.registerBeanDefinition("dataSource", beanDefinition);

        logger.info("多数据源注册成功");
    }

    /**
     * 初始化主库数据源
     * @return
     */

    public DataSource initMaterDataSource(JdbcXConfig jdbcXConfig) {

        Class<DataSource> dataSourceType;
        DataSource dataSource;
        try {

            dataSourceType = (Class<DataSource>) Class.forName(jdbcXConfig.getDbType());

            dataSource = DataSourceBuilder.create()
                    .driverClassName(jdbcXConfig.getDbJdbcDriverName())
                    .url(jdbcXConfig.getMasterURL())
                    .username(jdbcXConfig.getMasterUserName())
                    .password(jdbcXConfig.getMasterPassword())
                    .type(dataSourceType).build();

        } catch (ClassNotFoundException e) {
            logger.error("initMaterDataSource error",e);
            throw new RuntimeException(e.getLocalizedMessage());
        }

        return dataSource;
    }

    /**
     * 初始化主库数据源
     * @return
     */

    public DataSource initSlaveDataSource(JdbcXConfig jdbcXConfig) {
        Class<DataSource> dataSourceType;
        DataSource dataSource;
        try {
            dataSourceType = (Class<DataSource>) Class.forName(jdbcXConfig.getDbType());

            dataSource = DataSourceBuilder.create()
                    .driverClassName(jdbcXConfig.getDbJdbcDriverName())
                    .url(jdbcXConfig.getSlaveURL())
                    .username(jdbcXConfig.getSlaveUsername())
                    .password(jdbcXConfig.getSlavePassword())
                    .type(dataSourceType).build();

        } catch (ClassNotFoundException e) {
            logger.error("initSlaveDataSource error",e);
            throw new RuntimeException(e.getLocalizedMessage());
        }

        return dataSource;
    }

    /**
     * 加载数据源配置信息
     * @param dataSource
     * @param jdbcXConfig
     */
    private void dataBinder(DataSource dataSource, JdbcXConfig jdbcXConfig) {
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);

        dataBinder.setIgnoreNestedProperties(false);// false
        dataBinder.setIgnoreInvalidFields(false);// false
        dataBinder.setIgnoreUnknownFields(true);// true

        if (dataSourcePropertyValues == null) {
            Map<String, Object> values = Maps.newHashMap();
            values.put(JdbcXConfig.DB_INITIAL_SIZE,jdbcXConfig.getDbInitialSize());
            values.put(JdbcXConfig.DB_MIN_IDLE,jdbcXConfig.getDbMinIdle());
            values.put(JdbcXConfig.DB_MAX_ACTIVE,jdbcXConfig.getDbMaxActive());
            values.put(JdbcXConfig.DB_TEST_ON_BORROW,jdbcXConfig.getDbTestOnBorrow());
            values.put(JdbcXConfig.DB_FILTERS,jdbcXConfig.getDbFilters());

            dataSourcePropertyValues = new MutablePropertyValues(values);
        }
        dataBinder.bind(dataSourcePropertyValues);
    }
}
