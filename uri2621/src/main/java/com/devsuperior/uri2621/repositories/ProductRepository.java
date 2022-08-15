package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = "SELECT products.name FROM products "
			+ "INNER JOIN providers "
			+ "ON providers.id = products.id_providers "
			+ "WHERE products.amount BETWEEN 10 AND 20 "
			+ "AND providers.name LIKE CONCAT (UPPER(:initialProviderLetter), '%')")
	List<ProductProjection> search1(String initialProviderLetter);
	
	@Query(value = "SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) "
			+ "FROM Product obj "
			+ "WHERE obj.amount BETWEEN 10 AND 20 "
			+ "AND obj.provider.name LIKE CONCAT (UPPER(:initialProviderLetter), '%')")
	List<ProductMinDTO> search2(String initialProviderLetter);
}
