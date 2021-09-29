package com.haydikodlayalim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "persons")
@Getter //lombok dan gelir tum class a getter ekler, burada degisken ustune koyarsak sadece degiskene ekler
@Setter
@NoArgsConstructor //parametresiz constructor yarat
@AllArgsConstructor //tum field lar ile constructor yarat
public class Person {

    @Id
    private String id;

    @Field(name = "name", type = FieldType.Text)
    private String name;

    @Field(name = "surname", type = FieldType.Text)
    private String surName;

    @Field(name = "address", type = FieldType.Text)
    private String address;

    @Field(name = "birthday", type = FieldType.Date)
    private Date birthday;
}
