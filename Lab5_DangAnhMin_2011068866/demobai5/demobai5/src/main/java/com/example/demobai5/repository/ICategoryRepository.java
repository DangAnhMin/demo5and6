package com.example.demobai5.repository;

import com.example.demobai5.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long>{
}