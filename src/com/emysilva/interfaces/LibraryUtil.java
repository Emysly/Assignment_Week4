package com.emysilva.interfaces;

import com.emysilva.model.Book;

import java.io.IOException;

public interface LibraryUtil {
    void receiveRequestByPriority(String memberType);
    void lendBookByPriority(int bookId) throws IOException;
    void receiveRequestByFifo(String memberType);
    void lendBookByFifo(int bookId);
    void returnBook(int bookId);
    void getBooks();
    void addBook(Book book);
    void getBooksByTitle(String title);
    void removeBook(Book book);
    boolean getStatus(int bookId);
}
