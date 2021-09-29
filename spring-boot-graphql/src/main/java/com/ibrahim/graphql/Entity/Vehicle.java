package com.ibrahim.graphql.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
public class Vehicle implements Serializable { //nesneleri tüm özellikleriyle kullanabilmek için serializable interfaceinden implements ettik

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //postgresql de bu şekilde yapılmıyor, o bunu desteklemiyor
    private Long id;

    @Column(length = 100, name = "vehicle_type")
    private String type;

    @Column(length = 100, name = "model_code")
    private String modelCode;

    @Column(length = 100, name = "brand_name")
    private String brandName;

    @Column(length = 100, name = "launch_date")
    private Date launchDate;
}
