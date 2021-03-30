package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "email")
})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 8)
	private String password;
	
	private String contactNo;
	
	public User(String userName, String userEmail, String userPasswordHashed, String contactNo) {
		super();
		this.firstName = userName;
		this.email = userEmail;
		this.password = userPasswordHashed;
		this.contactNo = contactNo;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			joinColumns = @JoinColumn(name = "userId"),
			inverseJoinColumns = @JoinColumn(name = "roles_id")
			)
	private Set<Roles> roles = new HashSet<Roles>();
}

