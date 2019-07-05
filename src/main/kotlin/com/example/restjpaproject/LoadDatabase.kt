package com.example.restjpaproject

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoadDatabase {

    val logger = LoggerFactory.getLogger(LoadDatabase::class.java)

    @Bean
    fun initDatabase(repository: EmployeeRepository): CommandLineRunner {
        return CommandLineRunner { _ ->
            logger.info("Preloading " + repository.save(Employee("Bilbo Baggins", "burglar")))
            logger.info("Preloading " + repository.save(Employee("Frodo Baggins", "thief")))
        }
    }
}