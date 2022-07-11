package app.service;

import app.entity.Director;
import app.repository.DirectorRepository;
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
class DirectorServiceTest
{
    @Mock
    DirectorRepository directorRepository;
    DirectorService directorService;

    @BeforeEach
    void setUp()
    {
        directorService=new DirectorService(directorRepository);
    }
    @Test
    void save()
    {
        Director director=new Director();
        Mockito.when(directorRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Director.class));
        Director saved=directorService.save(director);
        Assertions.assertEquals(saved,director);
    }
    @Test
    void update()
    {
        Director director=new Director();
        Mockito.when(directorRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Director.class));
        Director updated=directorService.update(director);
        Assertions.assertEquals(updated,director);
    }
    @Test
    void deleteById()
    {
        directorService.deleteById(Long.valueOf("1"));
        Mockito.verify(directorRepository).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsDirector()
    {
        Director director=new Director();
        Mockito.when(directorRepository.findById(Mockito.any())).thenReturn(Optional.of(director));
        Director actual=directorService.findById(Long.valueOf("1"));
        Assertions.assertEquals(actual,director);
    }
    @Test
    void findById_throwsEntityNotFoundException()
    {
        Mockito.when(directorRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,()->directorService.findById(Long.valueOf("1")));
    }
    @Test
    void findAll()
    {
        Page<Director> page=new PageImpl<>(List.of(new Director()));
        Mockito.when(directorRepository.findAll(Mockito.any(Pageable.class))).thenReturn(page);
        Page<Director> actual=directorService.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
}