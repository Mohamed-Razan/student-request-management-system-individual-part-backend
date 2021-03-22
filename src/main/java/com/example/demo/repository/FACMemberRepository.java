package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FACMember;

public interface FACMemberRepository extends JpaRepository<FACMember, Integer> {

}
