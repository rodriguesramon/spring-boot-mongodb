package com.ramoncosta.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramoncosta.mongodb.domain.Post;
import com.ramoncosta.mongodb.repository.PostRepository;
import com.ramoncosta.mongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Post post = postRepository.findById(id).orElse(null);
		if(post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitle(text);
	}
	
	
	
	
	
}
