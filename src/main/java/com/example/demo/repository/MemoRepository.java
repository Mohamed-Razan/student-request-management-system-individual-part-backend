package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FACMember;
import com.example.demo.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer> {

	List<Memo> findByFacMember(FACMember facMember);
}
