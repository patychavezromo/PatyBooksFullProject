package org.example.classifybooksbyauthor;
import org.example.Autor.Author;
import org.example.Book.Book;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.*;


@Component
public class BookListIdentifierByAuthor {


    public Map<DbAuthor,List<Book>> getBooksByAuthor (List<Map<String,Object>> dbRows){
        Map<DbAuthor,List<Book>> authors = new HashMap<>();
        for(int i=0; i<dbRows.size(); i++){
            Map<String, Object> currentRow = dbRows.get(i);
            Book book =new Book(
                    (int)currentRow.get("id_book"),
                    (String)currentRow.get("book_name"),
                    (int)currentRow.get("quantity")
            );
            DbAuthor dbAuthor = new DbAuthor(
                    (String) currentRow.get("author_name"),
                    (int) currentRow.get("id_author")
            );
            if(!authors.containsKey(dbAuthor)) {
                List<Book> booksFromAuthor=new LinkedList<>();
                booksFromAuthor.add(book);
                authors.put(dbAuthor,booksFromAuthor);
            }else{
                List<Book> booksFromAuthor= authors.get(dbAuthor);
                booksFromAuthor.add(book);
                authors.put(dbAuthor,booksFromAuthor);
            }
        }
        return authors;
    }



}
