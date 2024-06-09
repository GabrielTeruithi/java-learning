package gteruithi.springframework.spring6webapp.services;

import gteruithi.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
