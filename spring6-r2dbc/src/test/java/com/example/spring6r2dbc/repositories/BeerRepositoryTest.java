package com.example.spring6r2dbc.repositories;

import com.example.spring6r2dbc.config.DatabaseConfig;
import com.example.spring6r2dbc.domain.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

@DataR2dbcTest
@Import(DatabaseConfig.class)
class BeerRepositoryTest {
    @Autowired
    BeerRepository beerRepository;

    @Test
    void saveNewBeer() {
        beerRepository.save(getTestBeer()).subscribe(beer -> System.out.println(beer.toString()));
    }

    Beer getTestBeer() {
        return Beer.builder()
                .beerName("SpaceDust")
                .beerStyle("IPA")
                .price(BigDecimal.TEN)
                .quantityOnHand(12)
                .upc("1235312")
                .build();
    }
}