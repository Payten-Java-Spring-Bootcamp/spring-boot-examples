package com.haydikodlayalim.controller;

import com.haydikodlayalim.dto.PersonDto;
import com.haydikodlayalim.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService; //requiredArgsConstructor var ve bu final yani diyorki bu class in constructor inda bu nesne injekte edilmeli kesinlikle!!
    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll(){
        return ResponseEntity.ok(personService.getAll());
    }

}
