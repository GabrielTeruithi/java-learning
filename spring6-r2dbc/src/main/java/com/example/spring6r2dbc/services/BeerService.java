package com.example.spring6r2dbc.services;

import com.example.spring6r2dbc.domain.BeerDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

public interface BeerService {
    Flux<BeerDTO> listBeers();
}
