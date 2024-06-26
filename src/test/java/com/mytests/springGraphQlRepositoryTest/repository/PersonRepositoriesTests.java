/*
 * Copyright 2020-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mytests.springGraphQlRepositoryTest.repository;

import com.mytests.springGraphQlRepositoryTest.model.Person;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
class PersonRepositoriesTests {

	@Autowired
	private GraphQlTester graphQlTester;

	// reference to file into documentName() arg
	@Test
	void querydslRepositorySingle() {
		this.graphQlTester.documentName("defaultSingle")
				.variable("id", 3)
				.execute()
				.path("person.firstName")  // JsonPath expected here
				.entity(String.class).isEqualTo("sasha");
	}

	// reference to file into documentName() arg
	@Test
	void querydslRepositoryMany() {
		this.graphQlTester.documentName("defaultPlural")
				.execute()
				.path("persons[*].id")  // JsonPath expected here
				.entityList(Integer.class).containsExactly(1,2,3);
	}

	// inject GraphQL request into myQuery
	@Test
	void querydslRepositoryFindAll() {
		String myQuery = """
                query findAll{
                    findAll{
                        id
                    }
                }""";
		this.graphQlTester.document(myQuery)
				.execute()
				.path("findAll[*].id")  // JsonPath expected here
				.entityList(Integer.class).containsExactly(1,2,3);
	}
	@Test
	void querydslRepositoryFindByAge() {
		String myQuery = """
                query {
                    findByAge(age:18){
                        id
                    }
                }""";
		this.graphQlTester.document(myQuery)
				.execute()
				.path("findByAge[*].id")  // JsonPath expected here
				.entityList(Integer.class).containsExactly(1);
	}
	@Test
	void querydslRepositoryCustomQuery() {
		String myQuery = """
                query {
                    customQuery(firstName:\"sasha\"){
                        id,
                        firstName,
                        lastName
                    }
                }""";
		this.graphQlTester.document(myQuery)
				.execute()
				.path("customQuery[*]")  // JsonPath expected here
				.entityList(Person.class).hasSize(1);
	}
}