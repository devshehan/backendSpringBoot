package com.shehaan.backendSpringBoot.service;

import com.shehaan.backendSpringBoot.dao.PersonDao;
import com.shehaan.backendSpringBoot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;
    }

    public int insertPerson(Person person){
       return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPersons();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }
}
