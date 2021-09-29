package com.haydikodlayalim.api;


import com.haydikodlayalim.Repository.PersonRepository;
import com.haydikodlayalim.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor //hangi fieldlar varsa onlarin constructorini ekle
@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonRepository personRepository;

    @PostConstruct
    public void init(){ //calisir calismaz kayit ekle
        Person person =new Person();
        person.setName("Haydi");
        person.setSurName("Kodlayalim");
        person.setAddress("test");
        person.setBirthday(Calendar.getInstance().getTime());
        person.setId("K0001");
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search){
        List<Person> persons = personRepository.getByCustomQuery(search);
        return ResponseEntity.ok(persons);
    }
}
