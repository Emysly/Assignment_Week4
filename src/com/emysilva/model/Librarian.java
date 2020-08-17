package com.emysilva.model;

import com.emysilva.interfaces.LibraryUtil;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.emysilva.enums.Priority.*;

public class Librarian implements LibraryUtil {

    public Librarian() {
    }

    private final List<Book> books = new ArrayList<>();
    private final Queue<Integer> priorities = new PriorityQueue<>();
    private final Queue<Integer> fifo = new ArrayDeque<>();


    public String getLogin_id() {
        return "admin";
    }

    public String getPassword() {
        return "password";
    }

    //implementation 1

    //adds the members(teacher, senior, junior) into the queue by their priority
    public void receiveRequestByPriority(String memberType) {
        switch(memberType.toLowerCase()) {
            case "teacher" -> priorities.add(TEACHER.ordinal());
            case "senior" -> priorities.add(SENIOR.ordinal());
            case "junior" -> priorities.add(JUNIOR.ordinal());
            default -> System.err.println("Member's type can only be of teacher, senior or junior");
        }
    }


    //before the book which is requested is lend out, it checks their priority
    // and gives the member with the highest priority first
    public void lendBookByPriority(int bookId) throws NullPointerException {

        //used scanner to get the librarian login details as specified in the librarian properties.
        //a librarian needs to produce his login details to be able to lend book to the members, just
        //like in real life scenario a librarian will have the key to the library.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your login id");
        String login_id = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();

        //checks if the librarian login details are correct before he can get access to lend book
        if (login_id.equalsIgnoreCase(getLogin_id()) && password.equalsIgnoreCase(getPassword())) {
            String poll = String.valueOf(priorities.poll());
            switchCase(bookId, Integer.parseInt(poll));
        } else {
            System.err.println("check your details and try again...");
        }
    }


    //implementation 2

    //adds the members(teacher, senior, junior) into the queue by first come first serve approach
    public void receiveRequestByFifo(String memberType) {
        switch(memberType.toLowerCase()) {
            case "teacher" -> fifo.add(TEACHER.ordinal());
            case "senior" -> fifo.add(SENIOR.ordinal());
            case "junior" -> fifo.add(JUNIOR.ordinal());
            default -> System.err.println("Member's type can only be of teacher, senior or junior");
        }
    }

    //before the book which is requested is lend out, it checks which member comes first
    // and gives the member first
    public void lendBookByFifo(int bookId) throws NullPointerException {

        //used scanner to get the librarian login details as specified in the librarian properties
        //a librarian needs to produce his login details to be able to lend book to the members, just
        //like in real life scenario a librarian will have the key to the library.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your login id");
        String login_id = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();

        if (login_id.equalsIgnoreCase(getLogin_id()) && password.equalsIgnoreCase(getPassword())) {
            String poll = String.valueOf(fifo.poll());
            switchCase(bookId, Integer.parseInt(poll));
        }
    }

    //checks if book is available or taken
    private void availableBook(int bookId) {
        Book availableBook = null;

//        Optional<Book> bookTaken = books.stream()
//                .filter(book -> book.getBookId() == bookId)
//                .findAny();
//
//        System.out.println(bookTaken);

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                availableBook = book;
                break;
            }

        }

        if (availableBook == null) {
            System.out.println("Book taken");
        } else {
            availableBook.borrowBook();
        }
    }

    //returns the book to the library
    public void returnBook(int bookId) {
        Predicate<Book> bookPredicate = book -> book.getBookId() == bookId;
        books.stream()
                .filter(bookPredicate)
                .forEach(Book::returnBook);
    }

    //gets all books
    public void getBooks() {
        books.forEach(System.out::println);
    }

    //adds book to the list of books
    public void addBook(Book book) {
        books.add(book);
    }

    //gets books using their title
    public void getBooksByTitle(String title) {
        Predicate<Book> bookTitlePredicate = book -> book.getTitle().equalsIgnoreCase(title);
        books.stream()
                .filter(bookTitlePredicate)
                .forEach(System.out::println);
    }

    //remove book from the list of books
    public void removeBook(Book book) {
        books.remove(book);
    }


    //checks if a book still has a copy
    public boolean getStatus(int bookId) {
        Predicate<Book> bookStatusPredicate = book -> book.getBookId() == bookId && book.getNumberOfCopies() > 0;
        return books.stream()
               .anyMatch(bookStatusPredicate);
    }


    //a method that checks the switch cases for both implementation 1(based on priority)
    // and implementation 2(based on first come first serve)
    private void switchCase(int bookId, int poll) {
        Predicate<Book> bookPredicate = book -> book.getBookId() == bookId;
        switch (poll) {
            case 1 -> books.stream()
                        .filter(bookPredicate)
                        .forEach(book -> System.out.println("Teacher borrowed " + book.getTitle()));

            case 2 -> books.stream()
                        .filter(bookPredicate)
                        .forEach(book -> System.out.println("Senior borrowed " + book.getTitle()));

            case 3 -> books.stream()
                        .filter(bookPredicate)
                        .forEach(book -> System.out.println("Junior borrowed " + book.getTitle()));

            default -> System.err.println("Book can only be borrowed by teachers and students");
        }
        availableBook(bookId);
    }
}
