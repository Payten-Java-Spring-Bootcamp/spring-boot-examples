package com.ibrahim.apiversioning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductV2 {

    private String name;
    private BigDecimal price;

    //burada ekstra field var ama bu field olmadan da uygulama çalışmalı
    //bu yüzden versiyonlama yaptık 2 entity oluşturduk
}
