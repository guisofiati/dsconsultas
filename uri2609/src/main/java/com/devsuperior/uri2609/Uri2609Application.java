package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(Uri2609Application.class);


	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Resultado em SQL raiz");
		List<CategorySumProjection> list = repository.search1();
		List<CategorySumDTO> dto = list.stream()
				.map(x -> new CategorySumDTO(x))
				.collect(Collectors.toList());
		
		for (CategorySumDTO obj : dto) {
			System.out.println(obj);
		}
		
		logger.info("Resultado em JPQL");
		List<CategorySumDTO> dto2 = repository.search2();
		
		for (CategorySumDTO obj : dto2) {
			System.out.println(obj);
		}
	}
}
