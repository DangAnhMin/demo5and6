package com.example.demobai5.repository;

import com.example.demobai5.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IBookRepository extends JpaRepository<Book, Long>{
}