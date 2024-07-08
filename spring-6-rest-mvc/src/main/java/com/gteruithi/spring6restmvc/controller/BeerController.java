package com.gteruithi.spring6restmvc.controller;

import com.gteruithi.spring6restmvc.model.Beer;
import com.gteruithi.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;


    @PatchMapping
    public ResponseEntity patchBeerById(@PathVariable("beerId")UUID beerId, @RequestBody Beer beer){
        log.debug("patchBeerById - BeerController.");
        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("{beerId}")
    public ResponseEntity deleteById(@PathVariable("beerId")UUID beerID) {
        log.debug("deleteById - BeerController.");
        beerService.deleteById(beerID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        log.debug("listBeers - BeerController.");

        return beerService.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug("getBeerById - BeerController. Beer ID: " + beerId);

        return beerService.getBeerById(beerId);
    }

    @PostMapping
    // @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addBeer(@RequestBody Beer beer) {
        log.debug("addBeer - BeerController.");

        Beer savedBeer = beerService.saveNewBear(beer);

        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateById(@PathVariable UUID beerId, @RequestBody Beer beer) {
        log.debug("updateById - BeerController. Beer ID: " + beerId);

        beerService.updateById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
