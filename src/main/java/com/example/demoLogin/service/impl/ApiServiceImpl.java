package com.example.demoLogin.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.demoLogin.domain.repository.UserLoginRepository;
import com.example.demoLogin.service.ApiService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService{
	
	private final UserLoginRepository repository;

	@Override
	public String login(String user, String password) throws Exception {
		
		var userLogin = repository.findByUsuario(user); 
		
		var tentFalha = 3L;
		if(Objects.isNull(userLogin)) {
			return "usuario nao cadastrado";
		}
		if( user.equals(userLogin.getUsuario()) && password.equals(userLogin.getPassword())) {
			userLogin.setTentativa(0L);
			repository.save(userLogin);
			return "senha está correta você está logado";
		}else {
			var cont = userLogin.getTentativa() +1;
			tentFalha = tentFalha  - cont;
			if( cont >2) {
				return "senha errada, utilizador bloqueado";
			}else {
				userLogin.setTentativa(cont);
				repository.save(userLogin);
				return String.format("senha está errada, tem %d tentativas restantes", tentFalha);
			}
		}
	}
}
