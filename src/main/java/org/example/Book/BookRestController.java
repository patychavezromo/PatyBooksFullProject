package org.example.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Book")
public class BookRestController {

    BookService bookService;

    @Autowired
    public BookRestController (BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping (value = "{id}")
    public Book getBook (@PathVariable ("id") int id){
        return this.bookService.findBookById(id);
    }

    @GetMapping
    public List<Book> getBooksList (){
        return this.bookService.findAllBooks();
    }


}
