package com.emysilva.test;

import com.emysilva.model.Library;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LibraryTest {

    Library library = null;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void getName() {
        assertNotNull(library.getName());
    }

    @AfterEach
    void tearDown() {
        library = null;
    }
}