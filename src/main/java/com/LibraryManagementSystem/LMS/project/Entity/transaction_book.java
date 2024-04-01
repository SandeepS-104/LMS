package com.LibraryManagementSystem.LMS.project.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction_book")
public class transaction_book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


 @ManyToOne
    @JoinColumn(name = "transaction_id")
   private transaction transaction_id;

    // transaction-book contains multiple books
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book_id;

    @Column(nullable = false)
    private Date return_date;

//    @ManyToOne
//    @JoinColumn(name="book_id")
//    private Book book_id;



    //private List<transaction> transactions ;

    public transaction_book() {
    }

    public transaction_book(transaction transaction_id, Book book_id, Date return_date) {
        this.transaction_id = transaction_id;
        this.book_id = book_id;
        this.return_date = return_date;
    }



    public transaction getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(transaction transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;


    }
}
