package com.ibrahim.exceptionhandling.service;

import com.ibrahim.exceptionhandling.dto.Car;
import com.ibrahim.exceptionhandling.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service //spring otomatik instance ı oluşturur.
public class CarService {

    private static List<Car> carList = new ArrayList<>();

    @PostConstruct //nesne instance ı yaratıldıktan sonra method bir kere çalışsın
    public void init(){
        carList.add(new Car("Car A", "Brand 1"));
        carList.add(new Car("Car B", "Brand 2"));
        carList.add(new Car("Car C", "Brand 3"));
    }

    public Car getCar(String name) {

        if(name.startsWith("1")){
            throw new IllegalArgumentException();
        } //bu şeklilde hata fırlatabiliriz ve bunları global olarak ApiExceptionHandler sınıfında kontrol edebiliriz
         return carList.stream().filter(item -> item.getName().equals(name)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException(name));
        //findfirst optional döner, bulamazsa exception dönecek
        //exception sınıfımızı kendimiz yazdık
    }
}
