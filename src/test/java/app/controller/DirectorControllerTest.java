package app.controller;

import app.entity.Director;
import app.service.DirectorService;
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
class DirectorControllerTest
{
    @Mock
    DirectorService directorService;
    DirectorController directorController;

    @BeforeEach
    void setUp()
    {
        directorController=new DirectorController(directorService);
    }
    @Test
    void save()
    {
        Director director=new Director();
        Mockito.when(directorService.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Director.class));
        Director saved=directorController.save(director);
        Assertions.assertEquals(saved,director);
    }
    @Test
    void update()
    {
        Long id=Long.valueOf("1");
        Director director=new Director();
        Mockito.when(directorService.update(Mockito.any())).thenAnswer(e->e.getArgument(0,Director.class));
        Director updated=directorController.update(director,id);
        Assertions.assertEquals(updated,director);
        Assertions.assertEquals(updated.getId(),id);
    }
    @Test
    void deleteById()
    {
        directorController.deleteById(Long.valueOf("1"));
        Mockito.verify(directorService).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsDirector()
    {
        Director director=new Director();
        Mockito.when(directorService.findById(Mockito.any())).thenReturn(director);
        Director actual=directorController.findById(Long.valueOf("1"));
        Assertions.assertEquals(actual,director);
    }
    @Test
    void findAll()
    {
        Page<Director> page=new PageImpl<>(List.of(new Director()));
        Mockito.when(directorService.findAll(Mockito.any())).thenReturn(page);
        Page<Director> actual=directorController.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
}