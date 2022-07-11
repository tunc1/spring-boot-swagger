package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Movie;
import app.repository.MovieRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class MovieService
{
	private MovieRepository movieRepository;
	public MovieService(MovieRepository movieRepository)
	{
		this.movieRepository=movieRepository;
	}
	public Movie save(Movie movie)
	{
		return movieRepository.save(movie);
	}
	public Movie update(Movie movie)
	{
		return movieRepository.save(movie);
	}
	public void deleteById(Long id)
	{
		movieRepository.deleteById(id);
	}
	public Movie findById(Long id)
	{
		return movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Page<Movie> findAll(Pageable pageable)
	{
		return movieRepository.findAll(pageable);
	}
}