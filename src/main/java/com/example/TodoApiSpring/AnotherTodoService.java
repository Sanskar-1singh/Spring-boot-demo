package com.example.TodoApiSpring;


import org.springframework.stereotype.Service;

@Service("anotherTodoService")
public class AnotherTodoService implements TodoService {

    @Override
    public String doSomething() {
        return "another Todo Service";
    }
}
