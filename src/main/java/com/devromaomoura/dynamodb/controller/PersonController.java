package com.devromaomoura.dynamodb.controller;

import com.devromaomoura.dynamodb.record.PersonRecord;
import com.devromaomoura.dynamodb.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Person Management System", description = "Operations related to managing persons")
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Operation(summary = "Add a new person")
    @PostMapping
    public ResponseEntity<PersonRecord> save(@RequestBody PersonRecord person) {
        PersonRecord savedPerson = personService.save(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a person by ID")
    @GetMapping("/{id}")
    public ResponseEntity<PersonRecord> getById(@PathVariable("id") String id) {
        PersonRecord person = personService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @Operation(summary = "Delete a person by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

