package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(Uri2611Application.class);
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Resultado em SQL raiz");
		List<MovieProjection> list = repository.search1("Action");
		List<MovieMinDTO> dto = list.stream()
				.map(x -> new MovieMinDTO(x))
				.collect(Collectors.toList());
		
		for (MovieMinDTO movie : dto) {
			System.out.println(movie);
		}
		
		logger.info("Resultado em JPQL");
		List<MovieMinDTO> dto2 = repository.search2("Action");
		
		for (MovieMinDTO obj : dto2) {
			System.out.println(obj);
		}
	}
}
