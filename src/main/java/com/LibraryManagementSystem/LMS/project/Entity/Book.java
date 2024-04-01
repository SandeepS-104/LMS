package com.LibraryManagementSystem.LMS.project.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne
    @JsonBackReference(value = "genre")
    @JoinColumn(name="genre_id")
    private Genre genre;

    @ManyToOne
    @JsonBackReference(value ="author")
    @JoinColumn(name="author_id")
    private Author author;

    @Column(name="quantity")
    private int quantity;

    @OneToMany(mappedBy = "book_id")
    private List<transaction_book> transactionBook;

   // @OneToMany(mappedBy ="book_id")
   // private List<transaction_book> transactionBookList;
   public void issueBook() {
       if (quantity > 0) {
           quantity--;
       }

   }

    public void returnBook() {
        quantity++;
    }



    public Book(int id) {
        this.id = id;
    }
}
