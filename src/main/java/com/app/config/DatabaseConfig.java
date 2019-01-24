package com.app.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
	
	public DataSource writeDevDataSource() throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("org.mariadb.jdbc.Driver");
		config.setJdbcUrl("jdbc:mariadb://localhost:");
		config.setUsername("");
		config.setPassword("");
		return new HikariDataSource(config);
	}
	
	public DataSource readDevDataSource() throws SQLException { 
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:mariadb://localhost:");
		config.setUsername("");
		config.setPassword("");
		return new HikariDataSource(config);
	}
	
	public DataSource writeEnvDataSource() throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("org.mariadb.jdbc.Driver");
		config.setJdbcUrl("jdbc:mariadb://localhost:");
		config.setUsername("");
		config.setPassword("");
		return new HikariDataSource(config);
	}
	
	public DataSource readEnvDataSource() throws SQLException { 
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("org.mariadb.jdbc.Driver");
		config.setJdbcUrl("jdbc:mariadb://localhost:");
		config.setUsername("");
		config.setPassword("");
		return new HikariDataSource(config);
	}

	@Bean
	@Profile("dev")
	public DataSource devDataSource() throws SQLException {
	    return new LazyReplicationConnectionDataSourceProxy(writeDevDataSource(), readDevDataSource());
	}
	
	@Bean
	@Profile("env")
	public DataSource localDataSource() throws SQLException {
		return new LazyReplicationConnectionDataSourceProxy(writeEnvDataSource(), readEnvDataSource());
	}
}
