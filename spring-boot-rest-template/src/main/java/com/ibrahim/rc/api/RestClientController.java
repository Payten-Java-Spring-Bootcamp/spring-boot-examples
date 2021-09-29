package com.ibrahim.rc.api;

import com.ibrahim.rc.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller //nesnesini üretir otomatik
@RequestMapping("/test")
public class RestClientController {

    private static final String webUrl = "http://localhost:8081/user"; //diğer projedeki adres postgresql projesinden

    @Autowired
    private RestTemplate restTemplate; //mainden aldı bunu ve artık elimizde bir nesne oldu

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersonList(){
        ResponseEntity<List> result = restTemplate.getForEntity(webUrl, List.class); //http isteği, bunlar için ayrı metot veya sınıf oluşturmak daha mantıklı
        List<PersonDto> responseBody = result.getBody();
        //ikinci parametre tip parametresi
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<PersonDto> kaydet(@RequestBody PersonDto personDto){
        ResponseEntity<PersonDto> result = restTemplate.postForEntity(webUrl, personDto, PersonDto.class); //http isteği, bunlar için ayrı metot veya sınıf oluşturmak daha mantıklı
        PersonDto responseBody = result.getBody();
        //üçüncü parametre dönen nesnenin tip parametresi
        return ResponseEntity.ok(responseBody);
    }

}
