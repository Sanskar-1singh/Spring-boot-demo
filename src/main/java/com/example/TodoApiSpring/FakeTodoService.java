package com.example.TodoApiSpring;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("bye_bye")
@Scope("singleton")
public class FakeTodoService implements TodoService{
    @Override
    @TimeMonitor
    public String doSomething() {
        return "doSomething";
    }
}


/**
 *
 * Aspect oriented  programming is a coding method that increases cross cuting concerns or aspect to increase
 * modularity.An aspect is subprogram that is associated with a specific property of a program.it  can be used with OOPS
 *
 * AOP is a programming pareadigms that aimsto increases modularity by allowing the sepration of corss cutting
 * concerns.ti does so by applying behaviour to existing code without modification of the code itself.
 */