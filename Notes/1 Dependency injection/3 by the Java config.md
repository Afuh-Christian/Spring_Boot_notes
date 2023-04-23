# Dependency injection by the java config ..... 00:37:59.987


# Step 1 ___________create a configuration class 

# src/main/java/BeanConfig.java 


package demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {
}
# ............... @ComponentScan fetches all the @Components in the demo folder........



# Step 2 ________________  use the AnnotationConfigApplicationContext  to get the BeanConfig class created ..... 

package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
# .________________________
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
# .________________________

        Doctor doctor = context.getBean(Doctor.class);

        doctor.assist();

    }
}



# Step 3 ..... LIke in annotation method .... we make the class we are to inject a component  .... 


src/main/java/Doctor

package demo;

import org.springframework.stereotype.Component;
# -----------
@Component
# -----------
public class Doctor implements  Staff {
    public void assist(){
        System.out.println("Doctor is assisting");
    }
}



# Step 3 method 2 ..... if we did not want to decorate the Doctor class with component .... we can still do this .... 

src/main/java/Doctor

package demo;

import org.springframework.stereotype.Component;

public class Doctor implements  Staff {
    public void assist(){
        System.out.println("Doctor is assisting");
    }
}

# Then do this in the BeanConfig class ... 

package demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {
# --------------------------
    @Bean
    public Doctor doctor(){
        return new Doctor();
    }
# --------------------------

}









