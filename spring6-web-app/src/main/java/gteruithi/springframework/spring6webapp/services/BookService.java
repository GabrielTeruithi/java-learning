package gteruithi.springframework.spring6webapp.services;

import gteruithi.springframework.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
