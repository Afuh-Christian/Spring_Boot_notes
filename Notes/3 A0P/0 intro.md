# AOP (Aspect Oriented Programming)     00:53:21.252
- A methodology in which we will create the application just like <OOP> 


# Advantages of Aspect oriented programming (AOP) 
- Gives us the flexibility to remove the cross cutting concern from our application and to separate it out from the main buisness logic 
- <So 'Cross-cutting-concerns are things out of buisness logic like 
    - Logging in a user 
    - Creating a new cart etc 
- <So 'Cross-cutting-concerns and 'Buisness-logic an ran separately >


# The different ways to implement ASPECT ORIENTED PROGRAMMING  
- <we will be using the 'aspect-j-liabary to implement 'AOP with spring framework >





# Step 1 ___________ On a new project (can be done on an existing project) 

- Add the dependencies in <the 'porm.xml file > 

# porm.xml 

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>Spring-AOP</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.16</version>
        </dependency>

# -----------------------------------------------------
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.7</version>
        </dependency>
# -----------------------------------------------------



    </dependencies>

</project>








# Let's add a Shopping cart class (make it a bean) and inject it using the annotation method by creating a bean config class


# demo/BeanConfig 

package demo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {

}

# demo/ShoppingCart
package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void showcart(){
        System.out.println("this is my cart");
    }
}


# demo/Main

package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);
        shoppingCart.showcart();
    }
}






# Now separating <the 'cross-cutting-concern from the 'buisness-logic


    public void showcart(){
        
        // Auth 
        // logging 
        // Sanitizing the data 
        
        //buisness logic
        System.out.println("this is my cart");
    }>

<The 'cross-cutting-concerns or the 'aspects
    // Auth 
    // logging 
    // Sanitizing the data 
        
<The 'buisness-logic 
    System.out.println("this is my cart");


# Step 1 .... create the <different 'Aspects for them and when creating the different aspects ... decorate them with the '@Aspect 
- <In the Aspects class , you could have a method that you wish to call before a particular buisness logic ... you decorate that method with '@Before 
- The <aspects should also be components so that they will be visible in springs radar by adding '@Component

* = denotes any return type 

# demo/LoggingAspect

package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
# --------run the logger() before the checkout()--------------
    @Before("execution(* demo.ShoppingCart.checkout())")
# ----------------------

    public void logger(){
        System.out.println("Loggers");
    }

}




# demo/AuthAspect


# Step 2 .... Enable them .... by <adding '@EnableAspectJAutoProxy on the BeanConfig class >

# demo/BeanConfig 

package demo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "demo")
@EnableAspectJAutoProxy
public class BeanConfig {

}




# Now when You run the code <it works ... 'success >

# What we just added are <called 'point-cuts and there are 5different types 
 - Before 
 - Before returning the value
 - After
 - After returning the value 
 - Around the method


 # Now  let's create for the 'After in the LoggingAspect 

# demo/LoggingAspect 

package demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout())")
    public void beforelogger(){
        System.out.println("Loggers");
    }
# -------------------------------
    @After("execution(* demo.ShoppingCart.checkout())")
    public void afterlogger(){
        System.out.println("After loggers");
    }
# -------------------------------

}

<works .. 'success>


# NB ... we can have 
 @After("execution(* *.*.checkout())")

 1st * = any return type 
 2nd * = any package 
 3rd * = any class
 # -------------------

 # NB ... if parameters are present in the method ... just place (..) that states what ever number of parameters are there , it will match.. 

  @After("execution(* *.*.checkout(..))")




  # Next we will create the Auth aspect .... 
  