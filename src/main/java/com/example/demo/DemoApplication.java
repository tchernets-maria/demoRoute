package com.example.demo;

import com.example.demo.conf.RoutingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {
	Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@Bean("masterDataSource")
	@ConfigurationProperties(prefix = "spring.one-datasource")
	DataSource masterDataSource() {
		logger.info("create master datasource...");
		return DataSourceBuilder.create().build();
	}

	@Bean("slaveDataSource")
	@ConfigurationProperties(prefix = "spring.two-datasource")
	DataSource slaveDataSource() {
		logger.info("create slave datasource...");
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	DataSource primaryDataSource(
			@Autowired @Qualifier("masterDataSource") DataSource masterDataSource,
			@Autowired @Qualifier("slaveDataSource") DataSource slaveDataSource
	) {
		logger.info("create routing datasource...");
		Map<Object, Object> map = new HashMap<>();
		map.put("masterDataSource", masterDataSource);
		map.put("slaveDataSource", slaveDataSource);
		RoutingDataSource routing = new RoutingDataSource();
		routing.setTargetDataSources(map);
		routing.setDefaultTargetDataSource(masterDataSource);
		return routing;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
