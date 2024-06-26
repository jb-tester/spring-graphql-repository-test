package com.mytests.springGraphQlRepositoryTest.repository;

import com.mytests.springGraphQlRepositoryTest.model.Gender;
import com.mytests.springGraphQlRepositoryTest.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

// navigation to schema, completion/navigation for typeName
@GraphQlRepository(typeName = "Person")
public interface PersonRepository extends
        CrudRepository<Person, String>, QuerydslPredicateExecutor<Person> {

    // navigation to/from schema for all methods;
    // completion for the methods inside schema
    // all methods are shown as unused (unless called explicitely in PersonRepositoryInitializer class)
    // navigation to Endpoints
    // ability to generate the HTTP Request

    List<Person> findByLastName(String lastName);

    List<Person> findByAge(int age);

    List<Person> findByGender(Gender gender);

    List<Person> findAll();

    @Query("select p from Person p where p.firstName = :firstName")
    List<Person> customQuery(String firstName);
}
