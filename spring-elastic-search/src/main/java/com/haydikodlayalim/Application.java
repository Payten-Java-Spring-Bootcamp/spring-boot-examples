package com.haydikodlayalim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories //elastic repo yu aktif hale getir
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
