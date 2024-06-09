package com.gteruithi.spring6reactive.repositories;

import com.gteruithi.spring6reactive.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

    Person michael = Person.builder().id(1).firstName("Michael").lastName("Weston").build();
    Person fiona = Person.builder().id(2).firstName("Fiona").lastName("Manchist").build();
    Person sam = Person.builder().id(1).firstName("Sam").lastName("Watson").build();
    Person jenne = Person.builder().id(1).firstName("Jenne").lastName("Penny").build();

    @Override
    public Mono<Person> getById(Integer id) {
        return Mono.just(michael);
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(michael,fiona,sam,jenne);
    }
}
