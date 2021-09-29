package com.ibrahim.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
graphql de iki tür api var

QueryResolver => api üstünde sorgulama yapmamızı saglar
MutationResolver => sunucumuzdaki bir takım kayıtlarımızı değiştirmek üzerine yayınlayabileceğimiz apileri bu class tan türetmeliyiz
 */
@SpringBootApplication
public class GraphQLApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraphQLApplication.class,args);
    }
}
