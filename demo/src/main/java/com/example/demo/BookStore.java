package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BookStore {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
      }
     public void setId(Integer id) {
     this.id = id;
      }    
  
    private String title;
    private String author;
    private String isbn;
    private String language;
    private int price;


    public void setTitle(String v)
    {
        title = v;
    }

    public String getTitle()
    {
        return title;
    }


    public void setAuthor(String v)
    {
        author = v;
    }

    public String getAuthor()
    {
        return author;
    }


    public void setIsbn(String i)
    {
        isbn = i;
    }

    public String getIsbn()
    {
        return isbn;
    }


    public void setLanguage(String l)
    {
        language = l;
    }
    public String getLanguage()
    {
        return language;
    }



    public void setPrice(int p)
    {
        price = p;
    }

    public int getPrice()
    {
        return price;
    }




}

