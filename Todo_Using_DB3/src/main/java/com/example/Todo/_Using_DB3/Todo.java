package com.example.Todo._Using_DB3;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class Todo {
    @Id

    private String id=UUID.randomUUID().toString();
    private String name;
    private String description;
    public Todo(String name,String description)
    {

        this.name=name;
        this.description=description;

    }
    public Todo()
    {

    }
    public String getId()
    {
        return id;

    }
    public void setId(String id)
    {

        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name)
    {this.name=name;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description=description;

    }
}

