package app.service;

import app.entity.Actor;
import app.repository.ActorRepository;
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
class ActorServiceTest
{
    @Mock
    ActorRepository actorRepository;
    ActorService actorService;

    @BeforeEach
    void setUp()
    {
        actorService=new ActorService(actorRepository);
    }
    @Test
    void save()
    {
        Actor actor=new Actor();
        Mockito.when(actorRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Actor.class));
        Actor saved=actorService.save(actor);
        Assertions.assertEquals(saved,actor);
    }
    @Test
    void update()
    {
        Actor actor=new Actor();
        Mockito.when(actorRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Actor.class));
        Actor updated=actorService.update(actor);
        Assertions.assertEquals(updated,actor);
    }
    @Test
    void deleteById()
    {
        actorService.deleteById(Long.valueOf("1"));
        Mockito.verify(actorRepository).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsActor()
    {
        Actor actor=new Actor();
        Mockito.when(actorRepository.findById(Mockito.any())).thenReturn(Optional.of(actor));
        Actor actual=actorService.findById(Long.valueOf("1"));
        Assertions.assertEquals(actual,actor);
    }
    @Test
    void findById_throwsEntityNotFoundException()
    {
        Mockito.when(actorRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,()->actorService.findById(Long.valueOf("1")));
    }
    @Test
    void findAll()
    {
        Page<Actor> page=new PageImpl<>(List.of(new Actor()));
        Mockito.when(actorRepository.findAll(Mockito.any(Pageable.class))).thenReturn(page);
        Page<Actor> actual=actorService.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
}