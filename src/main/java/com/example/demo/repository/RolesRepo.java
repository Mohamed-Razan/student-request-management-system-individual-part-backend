package com.example.demo.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MRoles;
import com.example.demo.entity.Roles;


public interface RolesRepo extends JpaRepository<Roles, Integer>{
	Optional<Roles>  findByName(MRoles name);
}
