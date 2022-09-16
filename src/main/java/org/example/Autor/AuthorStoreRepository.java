package org.example.Autor;

import java.util.List;

public interface AuthorStoreRepository {

    public List<Author> findAllAuthors();
}
