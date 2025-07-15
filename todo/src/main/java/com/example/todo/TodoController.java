package com.example.todo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TodoController {
    TodoService todoService = new TodoService();

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodoById(@PathVariable int id) {
        todoService.deleteTodoById(id);
    }
}
