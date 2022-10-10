package com.example.Todo._Using_DB3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController{
    @Autowired
    private TodoService todoItem;

    @RequestMapping("/todo")
    @ResponseStatus
    public ResponseEntity getAllTodo(){
        return new ResponseEntity<>(todoItem.getAllTodo(), HttpStatus.OK);

    }
    @RequestMapping("/todo/{id}")
    public ResponseEntity getTodo(@PathVariable String id)
    {
        if(todoItem.findTodo(id)==1) {
            return new ResponseEntity<>( todoItem.getTodo(id),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Todo Id does not exist",HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST,value = "/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo){
        todoItem.addTodo(todo);
        return new ResponseEntity<>("Todo Created Successfully.",HttpStatus.CREATED);

    }
    @RequestMapping(method =RequestMethod.PUT,value = "/todo/{id}")
    public ResponseEntity updateTodo(@RequestBody Todo todo,@PathVariable String id)
    {
        if(todoItem.updateTodo(id,todo)==1)
        {
            return new ResponseEntity<>("Todo Id:"+id+" Updated Successfully.",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Todo Id does not exist",HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/todo/{id}")
    public ResponseEntity deleteTodo(@PathVariable String id){
        if(todoItem.deleteTodo(id)==1)
        {
            return new ResponseEntity<>("Todo Id:"+id+" Deleted Successfully.",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Todo Id does not exist",HttpStatus.NOT_FOUND);
        }
    }
}

