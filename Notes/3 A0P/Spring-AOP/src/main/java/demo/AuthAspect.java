package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // make it  an aspect
@Component // make it visible to spring
public class AuthAspect {

    @Pointcut("within(demo..*)")
    public void authenticationPoinCut(){
        System.out.println("authenticationPoinCut");
    }
   @Pointcut("within(demo..*)")
    public void authorizationPoinCut(){
        System.out.println("authorizationPoinCut");
    }

    // Athenticate before running the above pointcuts
    @Before("authenticationPoinCut() || authorizationPoinCut()")
    public void authenticate(){
        System.out.println("Authenticate User");
    }
}
