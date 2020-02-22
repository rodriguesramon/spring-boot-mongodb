package com.ramoncosta.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ramoncosta.mongodb.domain.Post;
import com.ramoncosta.mongodb.domain.User;
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
		
		Post post1 = new Post(null, simpleDate.parse("22/02/2020"), "Partiu Viagem", "Vou pra Manaus, Tchau!", maria);
		Post post2 = new Post(null, simpleDate.parse("22/02/2020"), "Partiu Viagem", "Vou pra Manaus, Tchau!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
