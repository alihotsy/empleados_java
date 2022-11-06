package org.example.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class MyPostgresConfiguration {
    public static DataSource dataSource() {
        HikariConfig connection = new HikariConfig();
        connection.setUsername("root");
        connection.setPassword("root");
        connection.setJdbcUrl("jdbc:postgresql://localhost:5432/gestion_funcionarios");
        return new HikariDataSource(connection);
    }
}
