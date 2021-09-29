package com.ibrahim.graphql.repo;

import com.ibrahim.graphql.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {//vehicle ın id tipi long

    List<Vehicle> getByTypeLike(String type);

    //List<Vehicle> getByModelCodeOrBrandName(String type); //bu metotlar otomatik
    //bu yazımın bir mantığı var


}
