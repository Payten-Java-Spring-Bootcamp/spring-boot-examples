package com.ibrahim.exceptionhandling.api;

import com.ibrahim.exceptionhandling.dto.Car;
import com.ibrahim.exceptionhandling.exception.EntityNotFoundException;
import com.ibrahim.exceptionhandling.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarApi {

    private final CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name){
        return ResponseEntity.ok(carService.getCar(name));
    }

    /*

    //local olarak yönetebilmek için
    @ExceptionHandler(EntityNotFoundException.class) //EntityNotFoundException hatası alındıgında bu sınıf çalışsın
    public String entityNotFound(){
        return "Record not found";
    }

    */
}
