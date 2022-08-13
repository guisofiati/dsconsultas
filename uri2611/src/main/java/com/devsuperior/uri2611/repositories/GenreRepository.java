package com.devsuperior.uri2611.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2611.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
