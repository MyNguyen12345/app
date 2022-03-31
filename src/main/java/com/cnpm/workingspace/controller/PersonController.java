package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.model.Person;
import com.cnpm.workingspace.repository.PersonRepository;
import com.cnpm.workingspace.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "home")
    public ResponseEntity<String> home(){
        return new ResponseEntity<String>("This is home",HttpStatus.OK);
    }
    @GetMapping(value = "person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable(value = "id") int id){
        Optional<Person> person=personService.getPersonById(id);
        if(person.isPresent()){
            return new ResponseEntity<Person>(person.get(),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "person/")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> persons=personService.getAllPerson();
        if(persons.size()>0){
            return new ResponseEntity<List<Person>>(persons,HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "person/")
    public ResponseEntity<String> insertPerson(@RequestBody Person person){
        try{
            System.out.println("post method");
            System.out.println("person : "+person);
            personService.insertPerson(person);
            return new ResponseEntity<>("success",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("error : "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "person/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id,@RequestBody Person person){
        try{
            boolean status=personService.updatePerson(person,id);
            if(status){
                return new ResponseEntity<>("success",HttpStatus.OK);
            } else{
                return new ResponseEntity<>("not found person",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id){
        try{
            personService.deletePerson(id);
            return new ResponseEntity<>("success",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
