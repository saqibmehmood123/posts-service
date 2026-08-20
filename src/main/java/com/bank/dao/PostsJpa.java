package com.bank.dao;


import com.bank.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsJpa
        extends JpaRepository<Posts, Long>
{




}