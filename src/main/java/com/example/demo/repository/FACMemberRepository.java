package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FacMember;

public interface FACMemberRepository extends JpaRepository<FacMember, Integer> {

}
