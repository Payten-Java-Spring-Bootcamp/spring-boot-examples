package com.haydikodlayalim.repo;

import com.haydikodlayalim.entity.Address;
import com.haydikodlayalim.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
