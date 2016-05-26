package com.putracode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by KrisnaPutra on 5/26/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.putracode")
@EntityScan(basePackages="com.putracode.domain")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
