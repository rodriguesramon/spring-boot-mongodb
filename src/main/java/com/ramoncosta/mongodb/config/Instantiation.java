package com.ramoncosta.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ramoncosta.mongodb.domain.Post;
import com.ramoncosta.mongodb.domain.User;
import com.ramoncosta.mongodb.dto.AuthorDTO;
import com.ramoncosta.mongodb.dto.CommentDTO;
import com.ramoncosta.mongodb.repository.PostRepository;
import com.ramoncosta.mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		simpleDate.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria= new User(null, "Maria Brown", "maria@gmail.com");
		User alex= new User(null, "Alex Green", "alex@gmail.com");
		User bob= new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, simpleDate.parse("22/02/2020"), "Partiu Viagem", "Vou pra Manaus, Tchau!", new AuthorDTO(maria));
		Post post2 = new Post(null, simpleDate.parse("22/02/2020"), "Partiu Viagem", "Vou pra Manaus, Tchau!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Falow, vai pq quer!", simpleDate.parse("25/02/2020"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Tamo junto loko!", simpleDate.parse("27/02/2020"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Vainnnnnnn!", simpleDate.parse("27/02/2020"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
		
	}

}
