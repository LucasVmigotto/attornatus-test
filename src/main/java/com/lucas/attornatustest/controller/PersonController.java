package com.lucas.attornatustest.controller;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.attornatustest.model.Person;
import com.lucas.attornatustest.exception.NotFoundException;

import com.lucas.attornatustest.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonRepository repository;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> personList = repository.findAll();
        return new ResponseEntity<List<Person>>(personList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) throws NotFoundException {
        Optional<Person> exists = repository.findById(id);
        if(exists.isPresent()) {
            Person person = exists.get();
            return new ResponseEntity<Person>(person, new HttpHeaders(), HttpStatus.OK);
        } else {
            throw new NotFoundException("No person record exist for given id");
        }
    }

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person created = repository.save(person);
        return new ResponseEntity<Person>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable("id") Long id) throws NotFoundException {
        Optional<Person> personExists = repository.findById(person.getId());
        if (personExists.isPresent()) {
            Person updated = personExists.get();
            updated.setName(person.getName());
            updated.setBirthdate(person.getBirthdate());
            updated = repository.save(updated);
            return new ResponseEntity<Person>(updated, new HttpHeaders(), HttpStatus.OK);
        } else {
            throw new NotFoundException("No person record exist for given id");
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePersonById(@PathVariable("id") Long id) throws NotFoundException {
        Optional<Person> person = repository.findById(id);
        if (person.isPresent()) {
            repository.deleteById(id);
            return HttpStatus.OK;
        } else {
            throw new NotFoundException("No person record exist for given id");
        }
    }

}
