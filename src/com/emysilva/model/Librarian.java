package com.emysilva.model;

import com.emysilva.interfaces.LibraryUtil;

import java.util.*;

public class Librarian implements LibraryUtil {
    private String login_id = "admin";
    private String password = "password";

    public Librarian() {
    }

    private final List<Book> books = new ArrayList<>();
    private final List<String> members = new ArrayList<>();
    private final Queue<Integer> priorities = new PriorityQueue<>();
    private final LinkedList<Integer> fifo = new LinkedList<>();


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
        if (!memberType.equalsIgnoreCase("teacher")) {
            if (memberType.equalsIgnoreCase("senior")) {
                priorities.add(2);
                members.add(memberType);
            } else if (memberType.equalsIgnoreCase("junior")) {
                priorities.add(3);
                members.add(memberType);
            }
        } else {
            priorities.add(1);
            members.add(memberType);
        }
    }


    //before the book which is requested is lend out, it checks their priority
    // and gives the member with the highest priority first
    public void lendBookByPriority(int bookId) throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your login id");
        String login_id = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();

        //checks if the librarian login details are correct before he can get access to lend book
        if (login_id.equalsIgnoreCase(getLogin_id()) && password.equalsIgnoreCase(getPassword())) {
            int poll = priorities.poll();

            if (poll != 1) {
                if (poll != 2) {
                    if (poll == 3) {
                        for (Book book2 : books) {
                            if (book2.getBook_id() == bookId) {
                                System.out.println("Junior borrowed " + book2.getTitle());
                            }
                        }
                    } else {
                        System.err.println("Book can only be borrowed by teachers and students");
                    }
                } else {
                    for (Book book1 : books) {
                        if (book1.getBook_id() == bookId) {
                            System.out.println("Senior borrowed " + book1.getTitle());
                            break;
                        }
                    }
                }
            } else {
                for (Book book1 : books) {
                    if (book1.getBook_id() == bookId) {
                        System.out.println("Teacher borrowed " + book1.getTitle());
                        break;
                    }
                }
            }
            availableBook(bookId);
        } else {
            System.err.println("check your details and try again...");
        }
    }


    //implementation 2

    //adds the members(teacher, senior, junior) into the queue by first come first serve approach
    public void receiveRequestByFifo(String memberType) {
        if (memberType.equalsIgnoreCase("teacher")) {
            fifo.add(1);
            members.add(memberType);
        } else if (memberType.equalsIgnoreCase("senior")) {
            fifo.add(2);
            members.add(memberType);
        } else if (memberType.equalsIgnoreCase("junior")) {
            fifo.add(3);
            members.add(memberType);
        }
    }

    //before the book which is requested is lend out, it checks which member comes first
    // and gives the member first
    public void lendBookByFifo(int bookId) throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your login id");
        String login_id = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();

        if (login_id.equalsIgnoreCase(getLogin_id()) && password.equalsIgnoreCase(getPassword())) {
            int poll = fifo.pollFirst();

            if (poll == 1) {
                for (Book book1 : books) {
                    if (book1.getBook_id() == bookId) {
                        System.out.println("Teacher borrowed " + book1.getTitle());
                        break;
                    }
                }
            } else if (poll == 2) {
                for (Book book1 : books) {
                    if (book1.getBook_id() == bookId) {
                        System.out.println("Senior borrowed " + book1.getTitle());
                        break;
                    }
                }
            } else if (poll == 3) {
                for (Book book2 : books) {
                    if (book2.getBook_id() == bookId) {
                        System.out.println("Junior borrowed " + book2.getTitle());
                    }
                }
            } else {
                System.err.println("Book can only be borrowed by teachers and students");
            }
            availableBook(bookId);
        }
    }

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


}
