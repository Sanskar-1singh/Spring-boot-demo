package com.example.TodoApiSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Deprecated
 * @Deprecated only warns developers, it doesn’t deactivate the code.
 */

/**
 * there are two kind of injection ->
 * 1. field injection (NOT RECOMMENDED)
 * 2.Method injection (RECOMMENDED)
 */
@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {


    private TodoRepo todoRepo;
    private TodoService todoService;
    private TodoService anotherTodoService;
    private static List<Todo> todos;
    private static final String TODO_NOT_FOUND="todo not found";


    //here spring will automatically inject the todoservice while creating the todoController object
    //using IOC this is known as dependency injection>>
    public TodoController(
            @Qualifier("bye_bye") TodoService todoService,
            @Qualifier("anotherTodoService") TodoService anotherTodoService,
            @Qualifier("todoRepo") TodoRepo todoRepo) {
        todos = new ArrayList<Todo>();
        todos.add(new Todo(12, true, "running"));
        todos.add(new Todo(12, true, "running"));
        this.todoService = todoService;
        this.anotherTodoService = anotherTodoService;
        this.todoRepo = todoRepo;


    }

    /**
     * we should prefer constructor based dependency injection>>. rather than @Autowired
     */

    @GetMapping("/")
    //here all the seriealization and deserialization is handled by spring boot automatically into the required types
   //here we have send string as query params but it get converted to its is required type by spring boot
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false) Boolean isValid) {
        System.out.println(this.todoService.doSomething());
        List<Example> x=todoRepo.findAll();
        System.out.println(x);
        return ResponseEntity.ok(todos);
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
    //here we will use wildcard means here anything can comes as input>>
    public ResponseEntity<?> getTodoById(@PathVariable int id) {
        for(Todo t : todos) {
            if(t.getId() == id) {
                return ResponseEntity.ok().body(t);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TODO_NOT_FOUND);
    }

}

//In spring boot inversion of control plays very important ro1e because it says that all the responsiblity of creating
// the object of class is handled by spring boot only and hence ITS IOC

/**
 * A beans in spring is an object that is manged by the spring IOC container.it is a fundamental component
 * of a spring application and is resposnible for carrying out specific task.Beans can be created using annotations
 * ,XML configurations,or java  code
 *
 * when a spring application starts up the spring Ioc container scans the application for beans and create
 * instances for them.it then inject these beans into other beans that need them.this process is known as
 * dependeency injection
 *
 *
 * @Autowire->automatically include the class that implements the interface
 * @Qualifier->to include specific class
 * @Service->to tell spring manged it and it is service
 * @Respository->to tell spring mange and it is repo>>>>
 *
 *
 */

/**
 *
 * JDBC->java database connectivity
 *
 * it help in direct db interaction it directly uses jdbc to execute queries to a db queries are written
 * as string,and then pass the in function exposed by JDBC it uses connection driver to connect to particular databases;
 *
 *
 * JPA->java persistence API
 *
 * it is specification for accessing and persistating and managing data,btw objects ad relation tables;
 * it provide abstraction layer between user and JDBC that instead of writting raw queries we can use class and
 * object based syntax to interact with DB it consist of interface and annotations
 *
 * ORM->HIBERNATE
 *
 * it is cosnsits of class that impelement interafce and provide concrete impleemntation to interact with DB
 * but later on it feel that there are some method which are used very frquently why not included those method
 * and provide direct use of it to user so SPRING JPA DATA comes to the pictures
 *
 *
 * (JDBC->JPA->HIBERNATE->ORM->SPRING JPA)
 *
 *
 *
 */
