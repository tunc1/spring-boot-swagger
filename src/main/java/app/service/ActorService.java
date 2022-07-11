package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Actor;
import app.repository.ActorRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class ActorService
{
	private ActorRepository actorRepository;
	public ActorService(ActorRepository actorRepository)
	{
		this.actorRepository=actorRepository;
	}
	public Actor save(Actor actor)
	{
		return actorRepository.save(actor);
	}
	public Actor update(Actor actor)
	{
		return actorRepository.save(actor);
	}
	public void deleteById(Long id)
	{
		actorRepository.deleteById(id);
	}
	public Actor findById(Long id)
	{
		return actorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Page<Actor> findAll(Pageable pageable)
	{
		return actorRepository.findAll(pageable);
	}
}