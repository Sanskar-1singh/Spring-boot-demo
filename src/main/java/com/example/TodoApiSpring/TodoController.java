package com.example.TodoApiSpring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Deprecated
 * @Deprecated only warns developers, it doesn’t deactivate the code.
 */

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<Todo>();
        todos.add(new Todo(12, true, "running"));
        todos.add(new Todo(12, true, "running"));
    }

    @GetMapping("/")
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping("/change")
    public ResponseEntity<Todo> changeId(@RequestBody Todo newTodo) {
        todos.add(newTodo);
        /**
         * we can use this annottaions to set the status code @ResponseStatus(Httpstatus.CREATED)
         */
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int id) {
        for(Todo t : todos) {
            if(t.getId() == id) {
                return ResponseEntity.ok().body(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
