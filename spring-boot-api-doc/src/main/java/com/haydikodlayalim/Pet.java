package com.haydikodlayalim;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
//bu bir model dir

@Data //auto birkac annotation ekliyor
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "benim pet nesnem", description = "benim pet") //bu bir api model dir
public class Pet {

    @ApiModelProperty(value = "pet nesnesinin tekil id alani") //model property si
    private int id;

    @ApiModelProperty(value = "pet nesnesinin tekil ad alani")
    private String name;

    @ApiModelProperty(value = "pet nesnesinin tekil tarih alani")
    private Date date;
}
