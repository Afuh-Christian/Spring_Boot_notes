# Dependency injection by annotation base config  ... 00:35:16  .... 



# Step 1 ....____ Add the @Component decorator on the class that will be used in injection 

# src/main/java/demo/Doctor 

package demo;

import org.springframework.stereotype.Component;

@Component
public class Doctor implements  Staff {
    public void assist(){
        System.out.println("Doctor is assisting");
    }
}
# ...............

what ever the class we have created is a component that we can create a beans out of it ... 

# step 2 ..... we need to set in the spring.xml where we will be searching the components from ..... 



src/main/resources/spring.xml 

<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

<!-- We will search for the component in the demo folder  -->
#     <context:component-scan base-package="demo"></context:component-scan>


<!--     <bean id="doctor" class="demo.Doctor">-->
<!--         <constructor-arg value="MBMP"></constructor-arg>-->
<!--     </bean>-->
<!--     <bean id="nurse" class="demo.Nurse"></bean>-->


</beans>


#  Step 3 _______________________ Now in the main use thesame methods as before .... 

src/main/java/demo/Main.java

package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
# __________________________
     ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
# __________________________


    }
}



# Now to also make Nurse a @Component , we just need to 

src/main/java/demo/Nurse.java 

package demo;

import org.springframework.stereotype.Component;

# .....................
@Component
# ......................
public class Nurse  implements  Staff{
    public void assist(){
        System.out.println("Nurse is assisting");
    }
}




# Now Nurse has been injected ..... and can be used ....