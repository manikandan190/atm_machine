package com.example.Todo._Using_DB3;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends CrudRepository<Todo,String> {
}

