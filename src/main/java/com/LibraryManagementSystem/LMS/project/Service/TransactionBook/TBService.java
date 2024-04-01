package com.LibraryManagementSystem.LMS.project.Service.TransactionBook;

import com.LibraryManagementSystem.LMS.project.DAO.BookDao;
import com.LibraryManagementSystem.LMS.project.DAO.TBRepository;
import com.LibraryManagementSystem.LMS.project.Entity.Book;
import com.LibraryManagementSystem.LMS.project.Entity.transaction_book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TBService {
    private final TBRepository tbRepository;
    private final BookDao bookdao;

    @Autowired
    public TBService(TBRepository tbRepository, BookDao bookdao) {
        this.tbRepository = tbRepository;
        this.bookdao = bookdao;
    }

    public transaction_book saveTransaction_Book(transaction_book transaction_book)
    {
        return  tbRepository.save(transaction_book);
    }

    public List<transaction_book> getAllTransaction_Book() {
        return tbRepository.findAll();
    }

    public Optional<transaction_book> getTransaction_BookById(int id) {
        return tbRepository.findById(id);
    }


    public transaction_book updateTransactionBook(int id, transaction_book transactionBook) {
        Optional<transaction_book> existingTransactionBookOptional = tbRepository.findById(id);

        if (existingTransactionBookOptional.isPresent()) {
            transaction_book existingTransactionBook = existingTransactionBookOptional.get();
            existingTransactionBook.setBook_id(transactionBook.getBook_id());
            existingTransactionBook.setTransaction_id(transactionBook.getTransaction_id());
            existingTransactionBook.setReturn_date(transactionBook.getReturn_date());

            return tbRepository.save(existingTransactionBook);
        } else {
            throw new RuntimeException("Transaction Book Not Found");
        }
    }


    public void deleteTransactionBook(int id) {

        tbRepository.deleteById(id);
    }

    public void issueBook(int bookId) {
        Book book = bookdao.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));
        book.issueBook(); // Call the non-static method on the book instance
        bookdao.save(book);
    }
    public void returnBook(int bookId) {

        Book book = bookdao.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));
        book.returnBook();
        bookdao.save(book);
    }
}

