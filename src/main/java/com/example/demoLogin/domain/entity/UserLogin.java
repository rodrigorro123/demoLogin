package com.example.demoLogin.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "userLogin")
@Data
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
	@Column(unique = true, name = "usuario")
	private String usuario;

	@Column( name = "passowrd")
	private String password;
	
	@Column( name = "tentativa")
	private Long tentativa;
	
}
