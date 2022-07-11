package app.controller;

import app.entity.Movie;
import app.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest
{
    @Mock
    MovieService movieService;
    MovieController movieController;

    @BeforeEach
    void setUp()
    {
        movieController=new MovieController(movieService);
    }
    @Test
    void save()
    {
        Movie movie=new Movie();
        Mockito.when(movieService.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Movie.class));
        Movie saved=movieController.save(movie);
        Assertions.assertEquals(saved,movie);
    }
    @Test
    void update()
    {
        Long id=Long.valueOf("1");
        Movie movie=new Movie();
        Mockito.when(movieService.update(Mockito.any())).thenAnswer(e->e.getArgument(0,Movie.class));
        Movie updated=movieController.update(movie,id);
        Assertions.assertEquals(updated,movie);
        Assertions.assertEquals(updated.getId(),id);
    }
    @Test
    void deleteById()
    {
        movieController.deleteById(Long.valueOf("1"));
        Mockito.verify(movieService).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsMovie()
    {
        Movie movie=new Movie();
        Mockito.when(movieService.findById(Mockito.any())).thenReturn(movie);
        Movie actual=movieController.findById(Long.valueOf("1"));
        Assertions.assertEquals(actual,movie);
    }
    @Test
    void findAll()
    {
        Page<Movie> page=new PageImpl<>(List.of(new Movie()));
        Mockito.when(movieService.findAll(Mockito.any())).thenReturn(page);
        Page<Movie> actual=movieController.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
}