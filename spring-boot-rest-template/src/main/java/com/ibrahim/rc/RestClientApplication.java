package com.ibrahim.rc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    //bu metot bir resttemplate nesnesi üretir
    //bean annotation ise buradan üretilen nesneyi IOC contaioner içine alır
    //bu sayede bir nesneyi her yerde kullanabiliriz
    //autowired ile veya constructor injection ile bu nesneyi kullanabileceğiz

    public static void main(String[] args) {
        SpringApplication.run(RestClientApplication.class,args);
    }
}
