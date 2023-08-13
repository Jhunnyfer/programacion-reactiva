package com.cedesistemas.reactive;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.sql.Connection;

@SpringBootApplication
public class ReactiveApplication {

	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory)
	{
		ConnectionFactoryInitializer connectionFactoryInitializer = new ConnectionFactoryInitializer();
		connectionFactoryInitializer.setConnectionFactory(connectionFactory);
		connectionFactoryInitializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		return  connectionFactoryInitializer;

	}
	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

}
