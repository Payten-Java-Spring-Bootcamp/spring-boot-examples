package com.ibrahim.graphql.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ibrahim.graphql.Entity.Vehicle;
import com.ibrahim.graphql.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//bu sınıf controller sınıfıdır graphql de resolver olarak isimlendiririz

@Component //instince ı yarat ve yayınla ben nesnesini oluşturmak zorunda kalmayayım
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleRepository vehicleRepository; //Bu interface ile biz veri tabanıyla haberleşeceğiz
    //final yapıp RequiredArgsConstructor dediğimizde artık bu elemanın nesnesi constructor ile oluşturulmuş oluyor

    public List<Vehicle> getVehicles(String type){
        return vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id){ //optional sınıfı null hatası dondurmez
        return vehicleRepository.findById(id);
    }

}
