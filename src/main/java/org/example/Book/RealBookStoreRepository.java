package org.example.Book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RealBookStoreRepository implements BookStoreRepository {

    private JdbcTemplate jdbcTemplate;

    public RealBookStoreRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Book> findAllBooks() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "SELECT* FROM books"
        );
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            Map<String, Object> row = rows.get(i);
            Book currentBook = new Book(
                    (int) row.get("id"),
                    (String) row.get("name"),
                    (int) row.get("quantity")
            );
            bookList.add(currentBook);
        }
        return bookList;
    }
}








