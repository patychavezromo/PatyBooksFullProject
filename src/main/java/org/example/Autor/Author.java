package org.example.Autor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;
import org.example.Book.Book;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@Jacksonized
public class Author {

    String nameAuthor;
    int id;
    List<Book> bookList;

}
