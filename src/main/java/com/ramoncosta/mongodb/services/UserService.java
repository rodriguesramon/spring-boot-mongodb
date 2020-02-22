package com.ramoncosta.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramoncosta.mongodb.domain.User;
import com.ramoncosta.mongodb.dto.UserDTO;
import com.ramoncosta.mongodb.repository.UserRepository;
import com.ramoncosta.mongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		User user = userRepository.findById(id).orElse(null);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
}
