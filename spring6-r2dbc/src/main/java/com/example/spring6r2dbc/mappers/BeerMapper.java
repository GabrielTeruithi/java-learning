package com.example.spring6r2dbc.mappers;

import com.example.spring6r2dbc.domain.Beer;
import com.example.spring6r2dbc.domain.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
