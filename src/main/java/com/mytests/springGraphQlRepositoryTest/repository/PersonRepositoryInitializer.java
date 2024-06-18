package com.mytests.springGraphQlRepositoryTest.repository;

import java.util.Arrays;
import java.util.List;

import com.mytests.springGraphQlRepositoryTest.model.Gender;
import com.mytests.springGraphQlRepositoryTest.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonRepositoryInitializer implements ApplicationRunner {

	private final PersonRepository repositories;

	public PersonRepositoryInitializer(PersonRepository repositories) {
		this.repositories = repositories;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Person> repositoryList = Arrays.asList(
				new Person(1,"vasya","pupkin", 18, Gender.MALE),
				new Person(2, "masha", "mikhailova", 20, Gender.FEMALE),
				new Person(3, "sasha", "sidorenko", 22, Gender.UNDEFINED));
		repositories.saveAll(repositoryList);
		/*System.out.println("== all person:");
		repositories.findAll().forEach(System.out::println);
		System.out.println("== all men:");
		repositories.findByGender(Gender.MALE).forEach(System.out::println);
		System.out.println("== person with age == 20:");
		repositories.findByAge(20).forEach(System.out::println);
		System.out.println("== person with lastname == pupkin:");
		repositories.findByLastName("pupkin").forEach(System.out::println);
        System.out.println("== person with firstname == sasha:");
		repositories.customQuery("sasha").forEach(System.out::println);*/

	}

}
