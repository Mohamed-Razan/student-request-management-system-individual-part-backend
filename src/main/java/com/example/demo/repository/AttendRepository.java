package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Attend;
import com.example.demo.entity.AttendKey;

public interface AttendRepository extends JpaRepository<Attend, AttendKey> {

}
