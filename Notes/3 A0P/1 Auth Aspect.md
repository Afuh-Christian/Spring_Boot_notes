# Auth Aspect 01:11:11.304 
- So we create the AuthAspect  and enable it ... 

# this part will be complex 

# NB ... 
- <so 'execute = for the method you wish to execute
- <so 'within = for the type of class you wish to execute


# <So '@Pointcut
- <for every method in all the classes , we wish to run the method below before them 
@Pointcut("within(demo..*))
- <or for a specfic class but any method in that class 
@Pointcut("within(demo.ShoppingCart.*))

- <To 'call these 'point-cuts above e.g >
 @Before("authenticationPoinCut() && authorizationPoinCut()")








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
   @Pointcut("within(demo.ShoppingCart.*)")
    public void authorizationPoinCut(){
        System.out.println("authorizationPoinCut");
    }
    
    // Athenticate before running the above pointcuts 
    @Before("authenticationPoinCut() && authorizationPoinCut")
    public void authenticate(){
        System.out.println("Authenticate");
    }
}







# Suppose we which to get the data in the parameter in the buisness logic method and use in the Aspects   01:16:10.160