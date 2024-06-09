package com.example.spring6r2dbc.bootstrap;

import com.example.spring6r2dbc.domain.Beer;
import com.example.spring6r2dbc.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        beerRepository.count().subscribe(count -> System.out.println("Count is: " + count));
    }

    private void loadBeerData() {
        beerRepository.count().subscribe(count -> {
            if (count == 0) {
                Beer beer1 = Beer.builder()
                        .beerName("Galaxy cat")
                        .beerStyle("Pale Ale")
                        .upc("41234")
                        .price(new BigDecimal("12.99"))
                        .quantityOnHand(122)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();
                Beer beer2 = Beer.builder()
                        .beerName("Daasd")
                        .beerStyle("Pfasf")
                        .upc("41234")
                        .price(new BigDecimal("12.99"))
                        .quantityOnHand(12)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();
                Beer beer3 = Beer.builder()
                        .beerName("Gqwfqwfqwf cat")
                        .beerStyle("IPA")
                        .upc("4124")
                        .price(new BigDecimal("142.99"))
                        .quantityOnHand(1232)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();
                beerRepository.save(beer1).subscribe();
                beerRepository.save(beer2).subscribe();
                beerRepository.save(beer3).subscribe();
            }
        });
    }
}
