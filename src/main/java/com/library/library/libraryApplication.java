package com.library.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.library"})
@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class} )
@ImportResource({"classpath:HibernateConfigs.xml"})
@EnableTransactionManagement
@Configuration
public class libraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(libraryApplication.class, args);
	}
}
