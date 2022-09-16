package org.example.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@Setter
@Getter
@Jacksonized

public class Book {

    int id;
    String name;
    int availableInWarehouse;

}
