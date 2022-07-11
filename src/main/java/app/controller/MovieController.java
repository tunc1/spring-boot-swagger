package app.controller;

import app.entity.Movie;
import app.service.MovieService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/movie")
public class MovieController
{
	private MovieService movieService;
	public MovieController(MovieService movieService)
	{
		this.movieService=movieService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Movie save(@RequestBody Movie movie)
	{
		return movieService.save(movie);
	}
	@PutMapping("/{id}")
	public Movie update(@RequestBody Movie movie,@PathVariable Long id)
	{
		movie.setId(id);
		return movieService.update(movie);
	}
	@GetMapping("/{id}")
	public Movie findById(@PathVariable Long id)
	{
		return movieService.findById(id);
	}
	@GetMapping
	public Page<Movie> findAll(Pageable pageable)
	{
		return movieService.findAll(pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		movieService.deleteById(id);
	}
}