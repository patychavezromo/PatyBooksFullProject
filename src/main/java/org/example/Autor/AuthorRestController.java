package org.example.Autor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("Author")
public class AuthorRestController {

    AuthorService authorService;

    public AuthorRestController (AuthorService authorService){
        this.authorService=authorService;
    }

    @GetMapping (value="{id}")
    public Author getAuthorById(@PathVariable ("id") int id){
        return authorService.findAuthorsById(id);
    }

    @GetMapping
    public List<Author> allAuthors (){
        return this.authorService.getAllAuthors();
    }


}
