package com.lucas.attornatustest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.attornatustest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
