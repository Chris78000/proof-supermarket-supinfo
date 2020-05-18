/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.thesupermarket.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author Chris
 */

@SpringBootApplication
@ComponentScan(basePackages = "cm.thesupermarket")
@EntityScan(basePackages = {"cm.thesupermarket.domain"})
@EnableJpaRepositories(basePackages = {"cm.thesupermarket.repository"})
@PropertySource("classpath:application.properties")
@EnableScheduling
public class AdminApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SpringApplication.run(AdminApplication.class, args);
    }
}