package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Director;
import app.repository.DirectorRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class DirectorService
{
	private DirectorRepository directorRepository;
	public DirectorService(DirectorRepository directorRepository)
	{
		this.directorRepository=directorRepository;
	}
	public Director save(Director director)
	{
		return directorRepository.save(director);
	}
	public Director update(Director director)
	{
		return directorRepository.save(director);
	}
	public void deleteById(Long id)
	{
		directorRepository.deleteById(id);
	}
	public Director findById(Long id)
	{
		return directorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Page<Director> findAll(Pageable pageable)
	{
		return directorRepository.findAll(pageable);
	}
}