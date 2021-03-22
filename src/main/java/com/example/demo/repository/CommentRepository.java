package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Comment;
import com.example.demo.entity.CommentKey;

public interface CommentRepository extends JpaRepository<Comment, CommentKey> {
	
}
