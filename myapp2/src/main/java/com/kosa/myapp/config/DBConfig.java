package com.kosa.myapp.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// Myapp2Application : main 함수를 포함한 클래스가 자동으로 생성
// @Configuration이 있는 클래스들의 객체를 만들어서 필요한 위치에서 함수들 호출
@Configuration
@PropertySource("classpath:/application.properties")
public class DBConfig {

	// 객체 두개 생성
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
}
