package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{}