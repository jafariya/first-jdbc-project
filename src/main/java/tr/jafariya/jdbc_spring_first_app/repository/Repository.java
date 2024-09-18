package tr.jafariya.jdbc_spring_first_app.repository;

import tr.jafariya.jdbc_spring_first_app.model.Book;

import java.util.List;

public interface Repository {

    public List<Book> findAllBooks();

    public Book findByID(Long id);
}
