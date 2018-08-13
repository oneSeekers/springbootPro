package com.demo.repository.common.db;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(TargetDataSource)")
    public void beforeSwitchMaster(JoinPoint point){

        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();

        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();

        String dataSource = DynamicDataSource.DEFAULT_DB;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);

            // 判断是否存在@TargetDataSource注解
            if (method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource annotation = method.getAnnotation(TargetDataSource.class);
                // 取出注解中的数据源名
                dataSource = annotation.value().getName();
            }
        } catch (Exception e) {
            logger.error("switch datasource error",e);
        }

        // 切换数据源
        DynamicDataSource.setDataSourceType(dataSource);

    }


    @After("@annotation(TargetDataSource)")
    public void afterSwitchDS(JoinPoint point){
        DynamicDataSource.clearDataSourceType();
    }
}
