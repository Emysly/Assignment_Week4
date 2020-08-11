package com.emysilva.test;

import com.emysilva.model.Book;
import com.emysilva.model.Librarian;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {

    Book book;
    Librarian librarian;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
       book = new Book(1, "Things Fall Apart", "Chinua Achebe", 20.5,
                "123-4567-890", new Date(), "Things fall apart is an interesting book",
                10);

       librarian = new Librarian();
       librarian.addBook(book);
    }

    @org.junit.jupiter.api.Test
    void getLogin_id() {
        assertNotNull(librarian.getLogin_id());
    }

    @org.junit.jupiter.api.Test
    void getPassword() {
        assertNotNull(librarian.getPassword());
    }

    @org.junit.jupiter.api.Test
    void getBooks() {
        assertTrue(librarian.getBooks().size() > 0);
    }


    @org.junit.jupiter.api.Test
    void getStatus() {
        if (book.getNumberOfCopies() > 0) {
         assertTrue(librarian.getStatus());
        } else {
            assertFalse(librarian.getStatus());
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        book = null;
        librarian = null;
    }
}