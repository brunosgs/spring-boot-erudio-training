package com.github.brunosgs.repository;

import com.github.brunosgs.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }
