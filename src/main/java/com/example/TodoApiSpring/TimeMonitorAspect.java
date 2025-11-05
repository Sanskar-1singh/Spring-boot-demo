package com.example.TodoApiSpring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logtime(ProceedingJoinPoint joinPoint){
        long start = System.currentTimeMillis();

        try{
           joinPoint.proceed();
        }
        catch(Throwable e){
          System.out.println(e.getMessage());
        }
        finally{
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Time taken: " + time + " ms");
        }
    }

}


/**
 * Join point->a point during the execution of a program such as the execution of method or handling of
 * execption.In spring AOP a join point always represent a method execution.
 *
 * it is places in your program where behaviour can be inserted
 *
 * Point cut->it is an expression that select one or more join points
 *
 * Advice->advice represent any action taken by aspect(cross cutting concern) at a particular join point
 * advice help to identify when the logic should be executed.
 *
 * BEFORE/AFTER/AROUND
 *
 * @Aspect is an annotation from AspectJ used in Spring to define cross-cutting concerns — logic
 * that applies across multiple parts of your app (like logging, security, or transactions)
 * without duplicating code.
 *
 *
 *       Around(Around(function()))
 *          ^     ^       ^
 *          |     |       |
 *          here 1st sround will get run and on jointProceed
 *          it call second around and then on that joinProceed ti execute function
 *
 *
 * NOTE->any reusable code that we  want to decouple and reuse at multiple place without direct
 *    inheritence or composition we use AOP and for that we use @Aspect and @interface to create annotations
 *
 */