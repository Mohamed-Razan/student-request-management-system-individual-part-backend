package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LateChanges;
import com.example.demo.entity.LateChangesKey;
import com.example.demo.entity.LateModuleChangeRequest;

public interface LateChangesRepository extends JpaRepository<LateChanges, LateChangesKey> {

	List<LateChanges> findByLateModuleChangeRequest(LateModuleChangeRequest lateModuleChangeRequest);
}
