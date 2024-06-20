package com.devromaomoura.dynamodb.repository;

import com.devromaomoura.dynamodb.domain.Person;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
}

