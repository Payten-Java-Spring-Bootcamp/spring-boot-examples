package com.ibrahim.redisapp.service;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    //uzun suren bir islem yapan metod
    @Cacheable(cacheNames = "mySpecialCache") //bu artik cache edilebilir bir metot
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(5000);
        return  "method calisti";
    } //thread olmasina ragmen metot cok hizli cevap veriyor. Sebebi ise redisCache icerisine return ifadesi konulur. Aradaki islem cache e dahil degil. Metot calismaya devam ediyor ancak return ifadesi en basta alindigi icin cevap cok hizli oluyor
    //cache belirli periyotlarda oldurulmelidir. cunku metot icerisi surekli guncellenebilir bu yuzden cache degismeli ama degismeden once olmeli
    //ilk calisma her zaman yavas olur sonraki calismalar metodu ogrendigi icin hizli olur
    //cache olunce gene yavas calisir sonra hizlanir

    @CacheEvict(cacheNames = "mySpecialCache") //cache i oldurur
    public void clearCache(){
        System.out.println("cache temizlendi");
    }
}
