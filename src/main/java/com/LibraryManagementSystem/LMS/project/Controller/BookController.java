package com.LibraryManagementSystem.LMS.project.Controller;

import com.LibraryManagementSystem.LMS.project.Entity.Book;
import com.LibraryManagementSystem.LMS.project.Service.Book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



    @RestController
    @CrossOrigin
    @RequestMapping("/book")
    public class BookController {

        @Autowired
        private BookService bookService;

        @Autowired
        public BookController(BookService bookService) {
            this.bookService = bookService;
        }
        @GetMapping
        public ResponseEntity<List<Book>> getAllBook()
        {
            List<Book> b= bookService.getAllBooks();
            return new ResponseEntity<>(b, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Book> createBook(@RequestBody Book book)
        {
            Book b= bookService.create(book);
            return new ResponseEntity<>(b, HttpStatus.CREATED);
        }
        @GetMapping("/{id}")
        public Book getBookById(@PathVariable int id)
        {
            Optional<Book> book = bookService.getBookById(id);
            return book.orElse(null);
        }

        @GetMapping("/byAuthor/{authorId}")
        public List<Book> getBookByAuthorId(@PathVariable int authorId)
        {
            Optional<List<Book>> optionalBooks=bookService.getBookByAuthorId(authorId);
            return optionalBooks.orElse(null);
        }

        @GetMapping("/byGenre/{genreId}")
        public List<Book> getBookByGenreId(@PathVariable int genreId)
        {
            Optional<List<Book>> optionalBooks=bookService.getBookByGenreId(genreId);
            return optionalBooks.orElse(null);
        }



    }


