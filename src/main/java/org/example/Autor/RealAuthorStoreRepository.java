package org.example.Autor;

import org.example.Book.Book;
import org.example.classifybooksbyauthor.BookListIdentifierByAuthor;
import org.example.classifybooksbyauthor.DbAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RealAuthorStoreRepository implements AuthorStoreRepository{

    private JdbcTemplate jdbcTemplate;
    private BookListIdentifierByAuthor bookListIdentifierByAuthor;

    @Autowired
    public RealAuthorStoreRepository (DataSource dataSource, BookListIdentifierByAuthor bookListIdentifierByAuthor){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
        this.bookListIdentifierByAuthor=bookListIdentifierByAuthor;
    }


    @Override
    public List<Author> findAllAuthors() {
        List<Map<String,Object>> rows= this.jdbcTemplate.queryForList(
                "select a.id as id_author, a.name as author_name, b.name as book_name, b.quantity, b.id as id_book " +
                        "from authors a " +
                        "inner join books b " +
                        "on a.id= b.id_author;"
                        );
        Map<DbAuthor,List<Book>> authors=this.bookListIdentifierByAuthor.getBooksByAuthor(rows);
        List<Author> listOfAllAuthors = new ArrayList<>();
        for(DbAuthor dbAuthor: authors.keySet()){
            List<Book> currentBookList= authors.get(dbAuthor);
            String nameAuthor=dbAuthor.getName();
            int idAuthor=dbAuthor.getId();
            Author currentAuthor= new Author(nameAuthor,idAuthor,currentBookList);
            listOfAllAuthors.add(currentAuthor);
        }
        return listOfAllAuthors;
    }
}
