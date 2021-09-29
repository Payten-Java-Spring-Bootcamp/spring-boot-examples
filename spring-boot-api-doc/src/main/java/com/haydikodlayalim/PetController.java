package com.haydikodlayalim;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim Pet API dokumantasyonum") //bu bir api dir(swagger icin)
public class PetController {

    private List<Pet> petList = new ArrayList<>();

    @PostConstruct //bu class in constructor i calistiktan sonra bu metot calissin
    public void init() {
        petList.add(new Pet(1, "Test Path", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "yeni pet ekleme metodu", notes = "bu metodu dikkatli kullan" ) //api http metotlarini tanimlar
    public ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "evcil hayvan")  Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "pet listeleme metodu", notes = "bu metot sayfalama yapar" )
    public ResponseEntity<List<Pet>> getAll(){
        return ResponseEntity.ok(petList);
    }

}
