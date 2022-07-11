package app.controller;

import app.entity.Actor;
import app.service.ActorService;
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
class ActorControllerTest
{
    @Mock
    ActorService actorService;
    ActorController actorController;

    @BeforeEach
    void setUp()
    {
        actorController=new ActorController(actorService);
    }
    @Test
    void save()
    {
        Actor actor=new Actor();
        Mockito.when(actorService.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Actor.class));
        Actor saved=actorController.save(actor);
        Assertions.assertEquals(saved,actor);
    }
    @Test
    void update()
    {
        Long id=Long.valueOf("1");
        Actor actor=new Actor();
        Mockito.when(actorService.update(Mockito.any())).thenAnswer(e->e.getArgument(0,Actor.class));
        Actor updated=actorController.update(actor,id);
        Assertions.assertEquals(updated,actor);
        Assertions.assertEquals(updated.getId(),id);
    }
    @Test
    void deleteById()
    {
        actorController.deleteById(Long.valueOf("1"));
        Mockito.verify(actorService).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsActor()
    {
        Actor actor=new Actor();
        Mockito.when(actorService.findById(Mockito.any())).thenReturn(actor);
        Actor actual=actorController.findById(Long.valueOf("1"));
        Assertions.assertEquals(actual,actor);
    }
    @Test
    void findAll()
    {
        Page<Actor> page=new PageImpl<>(List.of(new Actor()));
        Mockito.when(actorService.findAll(Mockito.any())).thenReturn(page);
        Page<Actor> actual=actorController.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
}