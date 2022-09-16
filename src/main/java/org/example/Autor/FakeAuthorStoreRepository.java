package org.example.Autor;

import org.example.Book.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


public class FakeAuthorStoreRepository implements AuthorStoreRepository{


    @Override
    public List<Author> findAllAuthors() {
        List<Book> jkrList= Arrays.asList(
                new Book (1,"harry potter 2",5),
                new Book (2,"harry potter 3",4),
                new Book (3,"harry potter 4",8),
                new Book (4,"lista Harcodeada",0)
        );


        List<Book> miguelDeCervantes= Arrays.asList(
                new Book (1,"El Quijote",10),
                new Book (2,"La cueva de Salamanca",5),
                new Book (3,"El retablo de las maravillas",6),
                new Book (4,"Lista Harcodeada",0)
        );

        List<Book> janeAusten = Arrays.asList(
                new Book(1,"orgullo y prejuicio",6),
                new Book(2,"Sensatez y sentimientos",8),
                new Book (3,"Persuasion",1),
                new Book (4,"emma",2),
                new Book(5,"Lista harcodeada",0)
        );

        List<Author> authorsList = Arrays.asList(
                new Author("JKR", 1, jkrList),
                new Author("Miguel de Cervantes", 2,miguelDeCervantes),
                new Author ("Jane Austen",3,janeAusten)
        );
        return authorsList;
    }
}
