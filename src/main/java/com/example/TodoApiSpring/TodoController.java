package com.example.TodoApiSpring;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

      private static List<Todo> todos;

      public TodoController() {
          todos = new ArrayList<Todo>();
          todos.add(new Todo(11,true,"running"));
          todos.add(new Todo(12,true,"running"));
}
}
