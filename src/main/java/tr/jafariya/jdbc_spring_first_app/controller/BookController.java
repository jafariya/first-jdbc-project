package tr.jafariya.jdbc_spring_first_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.jafariya.jdbc_spring_first_app.model.Book;
import tr.jafariya.jdbc_spring_first_app.repository.Repository;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private Repository bookRepository;

    public BookController(Repository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book/all")
    List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }


    @GetMapping("/book/{id}")
    public Book getByID(@PathVariable("id") Long id) {
        return bookRepository.findByID(id);
    }

}