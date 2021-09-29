package com.ibrahim.apiversioning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //tüm elemanlarla constructor
@NoArgsConstructor //parametresiz constructor
public class ProductV1 {

    private String name;

    //android v1 ile çalışırken ios v2 olsun
    //bu şekilde ayrılıklar olduğu zaman versiyonlama kullanılır
}
