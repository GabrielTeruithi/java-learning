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
        log.debug("listBeers - BeerServiceImpl");
        return new ArrayList<>(beerMap.values());
    }

    public BeerServiceImpl() {
        log.debug("Creating Beers - BeerServiceImpl");
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
        log.debug("getBeerById - BeerServiceImpl. Beer ID: " + id);

        return beerMap.get(id);
    }

    @Override
    public Beer saveNewBear(Beer beer) {
        log.debug("saveNewBear - BeerServiceImpl.");

        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .price(beer.getPrice())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .version(beer.getVersion())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }

    @Override
    public void updateById(UUID beerId, Beer beer) {
        log.debug("updateById - BeerServiceImpl.");
        log.debug("Beer ID: " + beerId);

        Optional.ofNullable(beerMap.get(beerId)).ifPresent(oldBeer -> {
            oldBeer.setId(beerId);
            oldBeer.setBeerName(!beer.getBeerName().isEmpty() && !beer.getBeerName().isBlank() ? beer.getBeerName() : oldBeer.getBeerName());
            oldBeer.setPrice(beer.getPrice() != null ? beer.getPrice() : oldBeer.getPrice());
            oldBeer.setUpc(!beer.getUpc().isEmpty() && !beer.getUpc().isBlank() ? beer.getUpc() : oldBeer.getUpc());
            oldBeer.setUpdateDate(LocalDateTime.now());
            oldBeer.setVersion(beer.getVersion() != null ? beer.getVersion() : oldBeer.getVersion());
            oldBeer.setQuantityOnHand(beer.getQuantityOnHand() != null ? beer.getQuantityOnHand() : oldBeer.getQuantityOnHand());
            oldBeer.setCreatedDate(oldBeer.getCreatedDate());
            oldBeer.setBeerStyle(beer.getBeerStyle() != null ? beer.getBeerStyle() : oldBeer.getBeerStyle());

            beerMap.put(oldBeer.getId(), oldBeer);
        });
    }
}
