package com.ibrahim.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso //bu uygulamada tek noktadan giris var demek, mesela facebook login i
public class FacebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacebookApplication.class, args);
    }

    //OAuth2 uygulamaya bir saglayici tarafindan login olmayi saglar. Mesela facebook login
}
