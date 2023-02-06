package com.example.demoLogin.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoLogin.domain.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{
	
	UserLogin findByUsuario(String usuario);
}
