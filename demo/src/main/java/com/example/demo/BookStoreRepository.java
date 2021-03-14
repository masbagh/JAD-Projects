package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface BookStoreRepository extends CrudRepository<BookStore, Integer> {
    
}
