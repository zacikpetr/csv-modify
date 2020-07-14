package com.example.csvmodify;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@SpringBootApplication
public class CsvModifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsvModifyApplication.class, args);
    }

}
