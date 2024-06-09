package com.gteruithi.spring6reactive.repositories;

import com.gteruithi.spring6reactive.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest {

    PersonRepository personRepository = new PersonRepositoryImpl();


    @Test
    void testMonoByIdBlock() {
        // Don't use this piece of crappy
        Mono<Person> personMono = personRepository.getById(1);
        Person person = personMono.block();
        System.out.println(person.toString());
    }

    @Test
    void testGetByIdSubscriber() {
        Mono<Person> personMono = personRepository.getById(1);

        personMono.subscribe(person -> System.out.println(person.toString()));
    }

    @Test
    void testMapOperation() {
        Mono<Person> personMono = personRepository.getById(1);
        personMono.map(person -> {
            return person.getFirstName();
        }).subscribe(firstName -> System.out.println(firstName));
    }

    @Test
    void testFluxBlockFirst() {
        // Again, don't use this, never block
        Flux<Person> personFlux = personRepository.findAll();
        Person person = personFlux.blockFirst();
        System.out.println(person);
    }

    @Test
    void testFluxSubscriber() {
        Flux<Person> personFlux = personRepository.findAll();
        personFlux.subscribe(person -> {
            System.out.println(person.toString());
        });
    }
    @Test
    void testFluxMap() {
        Flux<Person> personFlux = personRepository.findAll();
        personFlux.map(Person::getFirstName).subscribe(firstName -> System.out.println(firstName));
    }

    @Test
    void testFluxToList(){
        Flux<Person> personFlux = personRepository.findAll();
        Mono<List<Person>> listMono = personFlux.collectList();
        listMono.subscribe(list -> {
            list.forEach(person -> System.out.println(person.getFirstName()));
        });
    }

    @Test
    void testFilterOnName() {
        personRepository.findAll().filter(person -> person.getFirstName().equals("Fiona")).subscribe(person -> System.out.println(person.getFirstName()));
    }

    @Test
    void testGetById() {
        Mono<Person> fionaMono = personRepository.findAll().filter(person -> person.getFirstName().equals("Fiona")).next();

        fionaMono.subscribe(person -> System.out.println(person.getFirstName()));
    }

    @Test
    void testFindPersonByIdNotFound() {
        Flux<Person> personFlux = personRepository.findAll();
        final Integer id = 8;
        Mono<Person> personMono = personFlux.filter(person -> person.getId() == id).single();

        personMono.subscribe(person -> {
            System.out.println(person.toString());
        }, throwable -> {
            System.out.println("Error occurred in the mono");
            System.out.println(throwable.toString());
        });
    }

    @Test
    void testGetByIdFoundStepVerifier() {
        Mono<Person> personMono = personRepository.getById(3);
        StepVerifier.create(personMono).expectNextCount(1).verifyComplete();
        personMono.subscribe(person -> System.out.println(person.getFirstName()));
    }
}