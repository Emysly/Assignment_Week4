package com.emysilva.test;

import com.emysilva.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book = null;

    @BeforeEach
    void setUp() {
        book = new Book(1, "Things Fall Apart", "Chinua Achebe", 20.5,
                "123-4567-890", new Date(), "Things fall apart is an interesting book",
                10);
    }


    @Test
    void status() {
        if (book.getNumberOfCopies() == 0) {
            assertFalse(book.status());
        } else {
            assertTrue(book.status());
        }
    }

    @Test
    void returnBook() {
        if(book.getNumberOfCopies() < book.getActualCopies()) {
            assertTrue(book.returnBook());
        } else {
            assertFalse(book.returnBook());
        }
    }

    @Test
    void getTitle() {
        assertNotNull(book.getTitle());
    }

    @Test
    void getAuthor() {
        assertNotNull(book.getAuthor());
    }

    @Test
    void getIsbn() {
        assertNotNull(book.getIsbn());
    }

    @Test
    void getPublishDate() {
        assertNotNull(book.getPublishDate());
    }

    @Test
    void getDescription() {
        assertNotNull(book.getDescription());
    }


    @AfterEach
    void tearDown() {
        book = null;
    }
}