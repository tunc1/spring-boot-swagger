package app.service;

import app.entity.Movie;
import app.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest
{
    @Mock
    MovieRepository movieRepository;
    MovieService movieService;

    @BeforeEach
    void setUp()
    {
        movieService=new MovieService(movieRepository);
    }
    @Test
    void save()
    {
        Movie movie=new Movie();
        Mockito.when(movieRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Movie.class));
        Movie saved=movieService.save(movie);
        Assertions.assertEquals(saved,movie);
    }
    @Test
    void update()
    {
        Movie movie=new Movie();
        Mockito.when(movieRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Movie.class));
        Movie updated=movieService.update(movie);
        Assertions.assertEquals(updated,movie);
    }
    @Test
    void deleteById()
    {
        movieService.deleteById(Long.valueOf("1"));
        Mockito.verify(movieRepository).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsMovie()
    {
        Movie movie=new Movie();
        Mockito.when(movieRepository.findById(Mockito.any())).thenReturn(Optional.of(movie));
        Movie actual=movieService.findById(Long.valueOf("1"));
        Assertions.assertEquals(actual,movie);
    }
    @Test
    void findById_throwsEntityNotFoundException()
    {
        Mockito.when(movieRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,()->movieService.findById(Long.valueOf("1")));
    }
    @Test
    void findAll()
    {
        Page<Movie> page=new PageImpl<>(List.of(new Movie()));
        Mockito.when(movieRepository.findAll(Mockito.any(Pageable.class))).thenReturn(page);
        Page<Movie> actual=movieService.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
}