package org.example.Autor;

import org.example.Book.FakeBookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    AuthorStoreRepository authorStoreRepository;

    @Autowired
    public AuthorService(AuthorStoreRepository authorStoreRepository){
        this.authorStoreRepository=authorStoreRepository;
    }


    public Author findAuthorsById (int id){
        List<Author> listAuthors =this.authorStoreRepository.findAllAuthors();
        for(Author author: listAuthors){
            int currentId = author.getId();
            if(id==currentId){
                return author;
            }
        }
        return null;
    }


    public List<Author> getAllAuthors (){
        List<Author> allAutors = this.authorStoreRepository.findAllAuthors();
        return allAutors;
    }





}
