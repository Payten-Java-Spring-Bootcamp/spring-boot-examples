package com.ibrahim.logging.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j //Logger factory yazimindan bizi kurtariyor, log diye bir instace olusturur
@RestController
@RequestMapping("/log")
public class LogEndPoint {

    //Logger logger = (Logger) LoggerFactory.getLogger(LogEndPoint.class); //LoggerFactory class indan bu class a ozel logger olusturduk
    //bir proje icersiinde tek log yoneticisi yoktur, her class a ozel bir log instance i olur. bu instance icin loggerfactory kullaniyoruz. bu class asenkron calisir

    //spring uygulamasi default ta info log u ile calisir, yani suan  console da yalnizca bunlari goruyoruz, bunu application.properties icinde degistirebiliriz
    //root logumuzu : yani her seyin logunu, web logumuzu hibernate logumuzu, class logumuzu degistirebilirz

    //logback-spring.xml diye bir dosyamiz var, bu application.properties gibi bir configurasyon dosyasidir, loglarimizi nerde tutacagiz cinsleri seviyeleri ne tarzi seyler hep bunun icinde olur
    //application dosyasinda da bunu yapabilirsin
    //o yuzden application.properties deki su bilgileri sildim
    /*
    logging.level.root=INFO
    logging.level.org.springframework.web=INFO
    logging.level.org.com.ibrahim.logging.api=DEBUG
     */

    //spring.profiles.active=dev developer olarak calistir
    //log dosyasi da olusturuyor bu proje ve bize ait tum loglari oraya yaziyor

    //stdout apender i console yazilanlar icin, fileout appender i dosyaya yazilanlar icin
    //xml dosyasiyle ona gore oynayabiilirsin

    @GetMapping
    public String getDetails(){
        log.debug("get details metodu basladi"); //sadece debug ederken gormek icin boyle bir sey koyduk
        log.info("get details metodu basladi"); //info olarak gormek icin koydum
        return internalLogDetail();

    }

    private String internalLogDetail(){
        try{
            log.debug("internal log detail metodu basladi");
            Thread.sleep(1000);
            return "API Mesaj";
        }catch (InterruptedException e){
            log.error("Hata: {}", e);
        }
        return "";
    }

    /*
        Loglama asenkron olmalidir, loglama yuzunden gecikme yasamamak icin boyle olmali
        loglamada printStackTrace ve system.out.print kullanilmamalidir, log formatlarini bozuyor
        Sensitive Data olmamalidir, yani user info vs koyma log un icine
        Tum loglar merkezi bir yerde toplanmalidir. belirli formatta da olmalilar
        Level Dikkatli kullanilmali
        farkli leveller icin farkli appendar (handler) lar kullanilabilir
     */
}
