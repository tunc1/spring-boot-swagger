package app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie
{
    @Id
    @SequenceGenerator(name="Movie_SEQUENCE_GENERATOR",sequenceName="Movie_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Movie_SEQUENCE_GENERATOR")
    private Long id;
    private String name;
    private short releasedYear;
    @ManyToOne
    private Director director;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="movie_actor",joinColumns=@JoinColumn(name="movieId"),inverseJoinColumns=@JoinColumn(name="actorId"))
    private Set<Actor> actors;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public short getReleasedYear()
    {
        return releasedYear;
    }
    public void setReleasedYear(short releasedYear)
    {
        this.releasedYear=releasedYear;
    }
    public Director getDirector()
    {
        return director;
    }
    public void setDirector(Director director)
    {
        this.director=director;
    }
    public Set<Actor> getActors()
    {
        return actors;
    }
    public void setActors(Set<Actor> actors)
    {
        this.actors=actors;
    }
}