package com.emysilva;

import com.emysilva.model.Book;
import com.emysilva.model.Librarian;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Librarian librarian = new Librarian();

        librarian.addBook(new Book(1, "Things Fall Apart", "Chinua Achebe", 20.5,
                "123-4567-890", new Date(), "Things fall apart is an interesting book",
                10));

        librarian.addBook(new Book(2, "Purple Hibiscus", "Chimamanda Ngozi Adichie", 30,
                "123-4567-001", new Date(), "Purple hibiscus is an interesting book",
                5));

        System.out.println("Make request using the members priority....");

        librarian.receiveRequestByPriority("Senior");
        librarian.receiveRequestByPriority( "Teacher");
        librarian.receiveRequestByPriority("Junior");
        librarian.receiveRequestByPriority( "Senior");

        librarian.lendBookByPriority(1);
        librarian.lendBookByPriority(2);
        librarian.lendBookByPriority(1);
        librarian.lendBookByPriority(1);


        System.out.println();
        System.out.println("Make request using first come first serve approach....");

        librarian.receiveRequestByFifo("Senior");
        librarian.receiveRequestByFifo( "Teacher");
        librarian.receiveRequestByFifo("Junior");
        librarian.receiveRequestByFifo( "Senior");

        librarian.lendBookByFifo(1);
        librarian.lendBookByFifo(2);
        librarian.lendBookByFifo(2);
        librarian.lendBookByFifo(1);



        librarian.returnBook(1);
        librarian.returnBook(2);
        librarian.returnBook(1);

        System.out.println(librarian.getBooks());
    }
}