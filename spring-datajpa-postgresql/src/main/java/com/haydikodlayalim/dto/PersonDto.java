package com.haydikodlayalim.dto;

import lombok.Data;

import java.util.List;

//entity leri direkt olarak dis dunyaya acmak istemeyiz, disariya Dto ile konusuruz

@Data //otomatik olarak getter setter requiredargsconstructor tostring EqualsAndHashCode ekler, bunu koydugumuzda parametre giremiyoruz mesela equalsandhashcode a
public class PersonDto {
    private Long id;

    private String name;

    private String surname;

    private List<String> addresses;
}
