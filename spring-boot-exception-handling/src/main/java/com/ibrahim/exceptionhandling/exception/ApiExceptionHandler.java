package com.ibrahim.exceptionhandling.exception;


//global exception

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //RestController lardaki tüm hataları yakalar
//@ControllerAdvice ise mvc yapılarında kullanılır biz restapi geliştirdik şuan
public class ApiExceptionHandler {

    //local olarak yönetebilmek için
    @ExceptionHandler(EntityNotFoundException.class) //EntityNotFoundException hatası alındıgında bu sınıf çalışsın
    public String entityNotFound(){
        return "Record not found";
    }
    //burada hata sınıflarına göre hata mesajını değiştirebilirsin
    //en mantıklısı base bir exception sınıf oluştujr
    //tüm sınıflar ondan extends alsın
    //burada da o base sınıfı handler et
    //tek metot ile tüm hataları yakala

    @ExceptionHandler(IllegalArgumentException.class)
    public String iaException(){
        return "wrong parameter";
    }

}
