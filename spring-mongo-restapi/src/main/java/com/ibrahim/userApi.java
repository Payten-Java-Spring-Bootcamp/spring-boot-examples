package com.ibrahim;

import com.ibrahim.entity.User;
import com.ibrahim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class userApi {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct//Calistiginda calissin
    public void init(){
        User user = new User();
        user.setName("ibrahim");
        user.setSurName("kafkasli");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    //http metodlarinda post, olmayan datayi olusturmak icin, put hic olmayan datayi eklemek icin. delete ise data silmek icin kullanilir
}
