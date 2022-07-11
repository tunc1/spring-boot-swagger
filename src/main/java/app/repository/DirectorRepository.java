package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Director;

public interface DirectorRepository extends JpaRepository<Director,Long>{}