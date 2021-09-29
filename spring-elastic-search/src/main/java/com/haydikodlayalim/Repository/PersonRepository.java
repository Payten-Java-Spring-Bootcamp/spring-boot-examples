package com.haydikodlayalim.Repository;

import com.haydikodlayalim.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}") //elastic search query
    List<Person> getByCustomQuery(String search);


    //elastic search querylerini elastic search sitesinden ogrenebilirsin

    List<Person> findByNameLikeOrSoyadLike(String name, String surName); //biz hicbir sorgu yapmiyoruz elastic search otomatik olarak buluyor. elastic search bir query dir
}
