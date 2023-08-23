package com.shehaan.backendSpringBoot.api;

import com.shehaan.backendSpringBoot.model.Person;
import com.shehaan.backendSpringBoot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Validated @NonNull @RequestBody Person person){
        personService.insertPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePersonById(id);
    }

    @PutMapping(path = "/{id}")
    public int updatePersonById(@PathVariable("id") UUID id,@Validated @NonNull @RequestBody Person person){
        return personService.updatePersonById(id,person);
    }
}
