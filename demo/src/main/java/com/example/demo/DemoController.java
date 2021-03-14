package com.example.demo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


//    http-anrop 127:0:0:1:8080/bookstore
//          127:0:0:1:8080/bookstore/1


@RestController
public class DemoController {

    @Autowired
	private BookStoreRepository bookRepository;
    
    @GetMapping(path="/bookstore")
    List<BookStore> getAll(){
        var l = new ArrayList<BookStore>();
        for(BookStore r : bookRepository.findAll())
        {
            l.add(r);
        }
        return l; 
    }

    @GetMapping(path="/bookstore/{id}")
    BookStore getSingle(@PathVariable Integer id){
        return bookRepository.findById(id).get();
    }


    @PutMapping(path="/bookstore/{id}", consumes="application/json",  produces = "application/json")
    BookStore update(@PathVariable Integer id, @RequestBody BookStore updatedBook){
        BookStore dbBook =  bookRepository.findById(id).get();
        dbBook.setTitle(updatedBook.getTitle());
        dbBook.setAuthor(updatedBook.getAuthor()); 
        dbBook.setIsbn(updatedBook.getIsbn()); 
        dbBook.setLanguage(updatedBook.getLanguage());
        dbBook.setPrice(updatedBook.getPrice());         
        
        bookRepository.save(dbBook);
        return dbBook;
    }


    @PostMapping(path="/bookstore", consumes="application/json",  produces = "application/json")
    ResponseEntity<Object> add(@RequestBody BookStore p){
        bookRepository.save(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(p.getId())
        .toUri();
        return ResponseEntity.created(location).build();        
    }
  

}
