package com.hyuk.restapi.DbMigration;

import com.hyuk.restapi.Models.Employee;
import com.hyuk.restapi.Repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class EmployeeInit {

    private static final Logger log = LoggerFactory.getLogger(EmployeeInit.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Hyuk Chung", "Software Engineer")));
            log.info("Preloading " + repository.save(new Employee("James Do", "Business Analyst")));
        };
    }
}