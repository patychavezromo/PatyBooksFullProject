package org.example.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookStoreRepository bookStoreRepository;

    @Autowired
    public BookService (BookStoreRepository bookStoreRepository){
        this.bookStoreRepository=bookStoreRepository;
    }


    public Book findBookById (int id){
//        Book book = new Book(id,"harry potter", 3);
        List<Book> bookList = bookStoreRepository.findAllBooks();
        for(Book book : bookList){
            int currentId= book.getId();
            if(currentId==id){
                return book;
            }
        }
        return null;
    }

    public List<Book> findAllBooks(){
        return  bookStoreRepository.findAllBooks();
    }
}
