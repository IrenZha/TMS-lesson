package service;

import domain.Book;

import java.util.List;

public interface BookService {

    void saveBook(Book book);

    boolean isExistsBook(Book book);

    List<Book> search(String search);

    List<Book> getBooks();
}
