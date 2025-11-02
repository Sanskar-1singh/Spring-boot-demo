package com.example.TodoApiSpring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<Todo>();
        todos.add(new Todo(12, true, "running"));
        todos.add(new Todo(12, true, "running"));
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping("/change")
    public ResponseEntity<Todo> changeId(@RequestBody Todo newTodo) {
        todos.add(newTodo);
        /**
         * we can use this annottaions to set the status code @ResponseStatus(Httpstatus.CREATED)
         */
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);;
    }

}
