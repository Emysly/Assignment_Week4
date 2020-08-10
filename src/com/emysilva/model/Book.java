package com.emysilva.model;

import java.util.Date;
import java.util.List;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private double price;
    private String isbn;
    private Date publishDate;
    private String description;
    private int numberOfCopies;
    private int actualCopies;

    public Book() {

    }

    public Book(int bookId, String title, String author, double price, String isbn, Date publishDate, String description, int numberOfCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.description = description;
        this.numberOfCopies = numberOfCopies;
        this.actualCopies = numberOfCopies;
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

    public int getBook_id() {
        return bookId;
    }

    public void setBook_id(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public int getActualCopies() {
        return actualCopies;
    }

    public void setActualCopies(int actualCopies) {
        this.actualCopies = actualCopies;
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
