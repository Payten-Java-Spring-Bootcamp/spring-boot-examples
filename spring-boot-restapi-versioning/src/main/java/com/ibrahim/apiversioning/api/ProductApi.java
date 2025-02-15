package com.ibrahim.apiversioning.api;

import com.ibrahim.apiversioning.dto.ProductV1;
import com.ibrahim.apiversioning.dto.ProductV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductApi {

    //path le versionlama ekleme

    //localhost:8080/api/v1/product
    @GetMapping("/v1/product")
    public ResponseEntity<ProductV1> pathVersioningProductV1(){
        return ResponseEntity.of(Optional.of(new ProductV1("Hp Laptop")));
    }

    //localhost:8080/api/v2/product
    @GetMapping("/v2/product")
    public ResponseEntity<ProductV2> pathVersioningProductV2(){
        return ResponseEntity.of(Optional.of(new ProductV2("Asus Laptop", new BigDecimal(2500))));
    }


    //parametre ile versiyonlama

    //localhost:8080/api/param/product?apiVersion=1
    @GetMapping(value = "/param/product", params = "apiVersion=1")
    public ResponseEntity<ProductV1> paramVersioningProductV1(){
        return ResponseEntity.of(Optional.of(new ProductV1("Hp Laptop")));
    }

    //localhost:8080/api/param/product?apiVersion=2
    @GetMapping(value = "/param/product", params = "apiVersion=2")
    public ResponseEntity<ProductV2> paramVersioningProductV2(){
        return ResponseEntity.of(Optional.of(new ProductV2("Asus Laptop", BigDecimal.TEN)));
    }



    //header ile versiyonlama

    //localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "X-API-VERSION=1")
    public ResponseEntity<ProductV1> headerVersioningProductV1(){
        return ResponseEntity.of(Optional.of(new ProductV1("Hp Laptop")));
    }

    //localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "X-API-VERSION=2")
    public ResponseEntity<ProductV2> headerVersioningProductV2(){
        return ResponseEntity.of(Optional.of(new ProductV2("Asus Laptop", BigDecimal.TEN)));
    }

    //küçük veya orta ölçekli projelerde bunlar kullanılır
}
