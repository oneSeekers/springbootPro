package com.demo.repository.common.db;


import java.lang.annotation.*;

import com.demo.repository.common.db.enums.DataSourceTarget;


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    DataSourceTarget value() default DataSourceTarget.MASTER;
}
