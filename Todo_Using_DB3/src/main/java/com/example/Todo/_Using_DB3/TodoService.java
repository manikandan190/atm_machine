package com.example.Todo._Using_DB3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService{
    @Autowired
    private TodoRepository todoRepository;




    public List<Todo> getAllTodo(){
        List<Todo> todos=new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;

    }
    public Optional<Todo> getTodo(String id)
    {

        return  todoRepository.findById(id);
    }
    public int findTodo(String id)
    {
        if(todoRepository.existsById(id))
        {
            return 1;}
        else{
            return 0;

        }


    }
    public void addTodo(Todo todo)
    {

        todoRepository.save(todo);
    }
    public int  updateTodo(String id,Todo todo) {


            if (todoRepository.existsById(id)) {
                todoRepository.save(todo);

                return 1;
            }


        return 0;
    }

    public int deleteTodo(String id)
    {
        if(todoRepository.existsById(id))
        {
            todoRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

}
