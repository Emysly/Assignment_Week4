package com.emysilva;

import com.emysilva.model.Book;
import com.emysilva.model.Librarian;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Librarian library = new Librarian();

        library.addBook(new Book(1, "Things Fall Apart", "Chinua Achebe", 20.5,
                "123-4567-890", new Date(), "Things fall apart is an interesting book",
                10));

        library.addBook(new Book(2, "Purple Hibiscus", "Chinua Achebe", 20.5,
                "123-4567-890", new Date(), "Purple hibiscus is an interesting book",
                5));

        System.out.println("Make request using the members priority....");

        library.makeRequestByPriority("Senior");
        library.makeRequestByPriority( "Teacher");
        library.makeRequestByPriority("Junior");
        library.makeRequestByPriority( "Senior");

        library.lendBookByPriority(1);
        library.lendBookByPriority(2);
        library.lendBookByPriority(1);
        library.lendBookByPriority(1);


        System.out.println();
        System.out.println("Make request using first come first serve approach");

        library.makeRequestByFifo("Senior");
        library.makeRequestByFifo( "Teacher");
        library.makeRequestByFifo("Junior");
        library.makeRequestByFifo( "Senior");

        library.lendBookByFifo(1);
        library.lendBookByFifo(2);
        library.lendBookByFifo(1);
        library.lendBookByFifo(1);



        library.returnBook(1);
        library.returnBook(2);
        library.returnBook(1);

        System.out.println(library.getBooks());
    }
}