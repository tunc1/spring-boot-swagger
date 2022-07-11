package app.controller;

import app.entity.Actor;
import app.service.ActorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/actor")
public class ActorController
{
	private ActorService actorService;
	public ActorController(ActorService actorService)
	{
		this.actorService=actorService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Actor save(@RequestBody Actor actor)
	{
		return actorService.save(actor);
	}
	@PutMapping("/{id}")
	public Actor update(@RequestBody Actor actor,@PathVariable Long id)
	{
		actor.setId(id);
		return actorService.update(actor);
	}
	@GetMapping("/{id}")
	public Actor findById(@PathVariable Long id)
	{
		return actorService.findById(id);
	}
	@GetMapping
	public Page<Actor> findAll(Pageable pageable)
	{
		return actorService.findAll(pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		actorService.deleteById(id);
	}
}