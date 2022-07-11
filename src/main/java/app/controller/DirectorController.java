package app.controller;

import app.entity.Director;
import app.service.DirectorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/director")
public class DirectorController
{
	private DirectorService directorService;
	public DirectorController(DirectorService directorService)
	{
		this.directorService=directorService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Director save(@RequestBody Director director)
	{
		return directorService.save(director);
	}
	@PutMapping("/{id}")
	public Director update(@RequestBody Director director,@PathVariable Long id)
	{
		director.setId(id);
		return directorService.update(director);
	}
	@GetMapping("/{id}")
	public Director findById(@PathVariable Long id)
	{
		return directorService.findById(id);
	}
	@GetMapping
	public Page<Director> findAll(Pageable pageable)
	{
		return directorService.findAll(pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		directorService.deleteById(id);
	}
}