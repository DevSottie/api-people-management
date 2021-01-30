package com.springapi.personapi.repository;

import com.springapi.personapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
