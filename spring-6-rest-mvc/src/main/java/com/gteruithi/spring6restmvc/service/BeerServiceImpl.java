package com.gteruithi.spring6restmvc.service;

import com.gteruithi.spring6restmvc.model.Beer;
import com.gteruithi.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    @Override
    public List<Beer> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.GOSE)
                .upc("123431")
                .price(new BigDecimal(12))
                .quantityOnHand(3131)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank-")
                .beerStyle(BeerStyle.GOSE)
                .upc("123431")
                .price(new BigDecimal(12))
                .quantityOnHand(3131)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Itaipava")
                .beerStyle(BeerStyle.GOSE)
                .upc("123431")
                .price(new BigDecimal(12))
                .quantityOnHand(3131)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }


    @Override
    public Beer getBeerById(UUID id) {

        log.debug("getBeerById - BeerServiceImpl. ID: " + id);

        return beerMap.get(id);
    }
}
