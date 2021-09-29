package com.ibrahim.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.beans.JavaBean;

@Aspect //bu sinif aspect islemleri yapacak, yani bir yerleri dinleyecek
@Component //neden boyle cunku bu metodun instance i hicbir yerde olusturulmuyor, bu annotation onu saglayacak
public class ServiceAspect {

    @Before("execution(* com.ibrahim.aop.service.*.*(..))") //path deki tum metotlardan once bu metot  *(..) tum metotlar demek
    public void beforeGetMessage(JoinPoint joinPoint){ //joinpoint bizim o anki durumumuzu yakalar, yani surec bunun icinde
        System.out.println("mesaj ver metodundan once parametre yakalandi; " + joinPoint.getArgs()[0]); //0. parametre, parametre yoksa nullpointer exeption yer
        System.out.println(joinPoint.getSignature());
        //buradaki islemlerin suresi kisa olmali
    }

    @After("execution(* com.ibrahim.aop.service.*.*(..))")
    public void afterGetMessage(JoinPoint joinPoint){
        //loglama tarzi islemler burada yapilir, uzun sureli islemler
        System.out.println("mesaj ver metodundan sonra parametre yakalandi; " + joinPoint.getArgs()[0]); //0. parametre, parametre yoksa nullpointer exeption yer
        System.out.println(joinPoint.getSignature());

    }
}
