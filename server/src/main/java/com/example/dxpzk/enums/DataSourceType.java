package com.example.dxpzk.enums;

/**
 * @author zk
 * @since 2020-03-15
 */
public enum DataSourceType {

    DEFAULT("default", "default"),
    DATASOURCE_1("datasource1", "datasource1"),
    DATASOURCE_2("datasource1", "datasource2"),

    ;

    private String name;

    private String identity;

    DataSourceType(String name, String identity) {
        this.name = name;
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public String getIdentity() {
        return identity;
    }

    public static DataSourceType getDataSourceTypeByName(String name) {
        for (DataSourceType dataSourceType : DataSourceType.values()) {
            if (dataSourceType.name.equals(name)) {
                return dataSourceType;
            }
        }
        throw new RuntimeException("db is not exist." + name);
    }
}