package app.entity;

import javax.persistence.*;

@Entity
public class Director
{
    @Id
    @SequenceGenerator(name="Director_SEQUENCE_GENERATOR",sequenceName="Director_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Director_SEQUENCE_GENERATOR")
    private Long id;
    private String name,surname;
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
    public String getSurname()
    {
        return surname;
    }
    public void setSurname(String surname)
    {
        this.surname=surname;
    }
}