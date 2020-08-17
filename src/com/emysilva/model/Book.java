package com.emysilva.model;

import com.emysilva.interfaces.BookUtil;

import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Book implements BookUtil {
    private final int bookId;
    private final String title;
    private final String author;
    private final double price;
    private final String isbn;
    private final Date publishDate;
    private final String description;
    private final int actualCopies;
    private int numberOfCopies;


    public Book(int bookId, String title, String author, double price, String isbn, Date publishDate, String description, int numberOfCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.description = description;
        this.actualCopies = numberOfCopies;
        this.numberOfCopies = numberOfCopies;
    }


    //checks if the book u are searching for still has some copy left
    public boolean status() {
        boolean status;
        if (numberOfCopies == 0) {
            status = false;
            System.out.println(getTitle() + " taken");
        } else {
            System.out.println(getTitle() + " is available");
            status = true;
        }
        return status;
    }


    //here we collect a book from the library using the borrow method
    public void borrowBook() {
        if(numberOfCopies > 0) {
            this.numberOfCopies -= 1;
            System.out.println(getTitle() + " picked");
        }else {
            System.out.println(getTitle() + " taken");
        }
    }

    //use the return method to return back the book to the library
    public boolean returnBook() {
        if(this.numberOfCopies < actualCopies) {
            this.numberOfCopies += 1;
            System.out.println(getTitle() + " returned");
            return true;
        } else {
            System.err.println(getTitle() + " is complete, you can't return, you can only borrow");
            return false;
        }
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public int getActualCopies() {
        return actualCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", description='" + description + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                '}';
    }
}
