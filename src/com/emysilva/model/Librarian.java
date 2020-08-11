package com.emysilva.model;

import com.emysilva.enums.Priority;
import com.emysilva.interfaces.LibraryUtil;

import java.util.*;

public class Librarian implements LibraryUtil {
    private String login_id = "admin";
    private String password = "password";
    protected Library library;

    public Librarian() {
    }

    private final List<Book> books = new ArrayList<>();
    private final Queue<Integer> priorities = new PriorityQueue<>();
    private final Queue<Integer> fifo = new ArrayDeque<>();


    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    //implementation 1

    //adds the members(teacher, senior, junior) into the queue by their priority
    public void receiveRequestByPriority(String memberType) {
        switch(memberType.toLowerCase()) {
            case "teacher" -> priorities.add(Priority.TEACHER.ordinal());
            case "senior" -> priorities.add(Priority.SENIOR.ordinal());
            case "junior" -> priorities.add(Priority.JUNIOR.ordinal());
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
            case "teacher" -> fifo.add(Priority.TEACHER.ordinal());
            case "senior" -> fifo.add(Priority.SENIOR.ordinal());
            case "junior" -> fifo.add(Priority.JUNIOR.ordinal());
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
        for (Book book : books) {
            if (book.getBook_id() == bookId) {
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
        for (Book book: books) {
            if (book.getBook_id() == bookId) {
                book.returnBook();
                break;
            }
        }
    }

    //gets all books
    public List<Book> getBooks() {
        return books;
    }

    //adds book to the list of books
    public void addBook(Book book) {
        books.add(book);
    }

    //gets books using their title
    public void getBooksByTitle(String title) {
        books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).forEach(System.out::println);
    }

    //remove book from the list of books
    public void removeBook(Book book) {
        books.remove(book);
    }


    //checks if a book still has a copy
    public boolean getStatus() {
        for (Book book: books) {
            if (book.getNumberOfCopies() > 0) {
                return true;
            }
        }
        return false;
    }

    public String getLibraryName() {
        return library.getName();
    }


    //a method that checks the switch cases for both implementation 1(based on priority)
    // and implementation 2(based on first come first serve)
    private void switchCase(int bookId, int poll) {
        switch (poll) {
            case 1 -> {
                for (Book book1 : books) {
                    if (book1.getBook_id() == bookId) {
                        System.out.println("Teacher borrowed " + book1.getTitle());
                        break;
                    }
                }
            }
            case 2 -> {
                for (Book book1 : books) {
                    if (book1.getBook_id() == bookId) {
                        System.out.println("Senior borrowed " + book1.getTitle());
                        break;
                    }
                }
            }
            case 3 -> {
                for (Book book2 : books) {
                    if (book2.getBook_id() == bookId) {
                        System.out.println("Junior borrowed " + book2.getTitle());
                    }
                }
            }
            default -> System.err.println("Book can only be borrowed by teachers and students");
        }
        availableBook(bookId);
    }
}
