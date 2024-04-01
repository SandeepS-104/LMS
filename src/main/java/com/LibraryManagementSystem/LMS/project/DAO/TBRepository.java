package com.LibraryManagementSystem.LMS.project.DAO;


import com.LibraryManagementSystem.LMS.project.Entity.transaction_book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TBRepository extends JpaRepository<transaction_book,Integer> {
}
