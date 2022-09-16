package org.example.Book;

import java.util.Arrays;
import java.util.List;




public class FakeBookStoreRepository implements BookStoreRepository{

    @Override
    public List<Book> findAllBooks (){
        List<Book> bookList = Arrays.asList(
            new Book (1,"El Quijote",10),
            new Book (2, "Harry Potter", 5),
            new Book (3, "Orgullo y prejuicio", 13),
            new Book (4, "alicia en el pais de las maravillas",5),
            new Book (5,"el principito", 6)
        );
        return bookList;
    }
}
