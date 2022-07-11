package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor,Long>{}