package org.example.service.impl;

import org.example.config.AppSessionFactory;
import org.example.domain.Book;
import org.example.exception.BookExistsException;
import lombok.Data;
import org.example.service.BookService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BookServiceImpl implements BookService {

    static {
        Book book1 = new Book("title1", 100, "author2");
        Book book2 = new Book("title2", 200, "author1");
        Book book3 = new Book("title3", 300, "author1");
        Book book4 = new Book("title4", 400, "author3");
        Book book5 = new Book("title5", 500, "author3");

        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

        transaction.commit();
        session.close();

    }

    @Override
    public void saveBook(Book book) {
        if (!isExistsBook(book)) {
            Session session = AppSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();

            session.save(book);

            transaction.commit();
            session.close();
        } else {
            throw new BookExistsException();
        }
    }

    public boolean isExistsBook(Book book) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        boolean anyMatch = getBooks().stream()
                .anyMatch(book1 -> book1.equals(book));

        transaction.commit();
        session.close();
        return anyMatch;
    }

    @Override
    public List<Book> search(String search) {
        if (!search.isBlank()) {
            Session session = AppSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();

            var query = session.createQuery("from Book where title like :search or author like :search");
            query.setParameter("search", "%" + search + "%");
            List<Book> bookList = query.list();

            transaction.commit();
            session.close();
            return bookList;
        } else {
            List<Book> books = getBooks();
            return books;
        }
    }

    @Override
    public List<Book> getBooks() {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        List<Book> books = session.createQuery("from Book").list();

        transaction.commit();
        session.close();
        return books;
    }
}
