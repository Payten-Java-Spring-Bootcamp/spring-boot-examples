package com.ibrahim.repository;

import com.ibrahim.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

//Repository annotation kullanmamiza gerek yok zaten extends etmis
public interface UserRepository extends MongoRepository<User, String> {
    //bu sinif MongoRepository den extends ediyor, burada User kullanici toplantisini belli ediyor, String ise primary Key i temsil ediyor
    //mongodb semasiz bir veri tabani, bize getirdigi ozeliik budur
}
