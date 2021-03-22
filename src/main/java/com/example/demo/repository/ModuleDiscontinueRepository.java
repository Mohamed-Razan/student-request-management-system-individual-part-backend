package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AlternativeModuleRequest;
import com.example.demo.entity.ModuleDiscontinue;
import com.example.demo.entity.ModuleDiscontinueKey;


public interface ModuleDiscontinueRepository extends JpaRepository<ModuleDiscontinue, ModuleDiscontinueKey> {

	List<ModuleDiscontinue> findByAlterModuleRequest(AlternativeModuleRequest alterModuleRequest);
}
