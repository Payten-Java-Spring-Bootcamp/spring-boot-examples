package com.ibrahim.redisapp.api;

import com.ibrahim.redisapp.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {

    private int counter = 0;

    @Autowired //nesne uretmene gerek yok bu sekilde kullanabilirsin direkt
    private RedisCacheService redisCacheService;

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if(counter == 5){
            redisCacheService.clearCache();
            counter = 0;
        }
        counter++;
        return redisCacheService.longRunningMethod();
    }
}
