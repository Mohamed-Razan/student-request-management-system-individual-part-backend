package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Module1;

public interface ModuleRepository extends JpaRepository<Module1, String> {

}
