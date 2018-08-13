package com.demo.repository.common.db.enums;

/**
 *
 * 数据库标识
 */
public enum DataSourceTarget {
    MASTER("master"),// 主库
    SLAVE("slave")  // 从库

    ;


    private String name;

    DataSourceTarget(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
