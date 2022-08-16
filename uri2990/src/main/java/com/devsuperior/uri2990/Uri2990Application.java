package com.devsuperior.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(Uri2990Application.class);

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Resultado em SQL raiz");
		List<EmpregadoDeptProjection> list = repository.search1();
		List<EmpregadoDeptDTO> dto = list.stream()
				.map(x -> new EmpregadoDeptDTO(x))
				.collect(Collectors.toList());
		
		for (EmpregadoDeptDTO obj : dto) {
			System.out.println(obj);
		}
		
		logger.info("Resultado em JPQL");
		List<EmpregadoDeptDTO> dto2 = repository.search2();
		
		for (EmpregadoDeptDTO obj : dto2) {
			System.out.println(obj);
		}
	}
}
