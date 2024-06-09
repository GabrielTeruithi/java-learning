package com.example.spring6r2dbc.repositories;

import com.example.spring6r2dbc.domain.Beer;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {
}
