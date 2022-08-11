package com.example.rentcar.dao.repository;

import com.example.rentcar.dao.entity.BlogCommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BlogCommentsRepository extends JpaRepository<BlogCommentsEntity, Integer> {
    @Query("SELECT c FROM blog_comments c WHERE c.blogEntity.id = ?1")
    List<BlogCommentsEntity> findbyBlogID(Integer id);


//    @Query("SELECT c FROM blog_comments c WHERE c.blogEntity.id = ?1")
//    void deleteByBlogId(Integer id);

//    @Override
//    @Query("SELECT c FROM blog_comments c WHERE c.blogEntity.id = ?1")
//    void deleteById(Integer id);
//
//
}