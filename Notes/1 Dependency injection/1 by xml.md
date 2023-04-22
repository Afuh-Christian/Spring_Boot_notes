# by xml             00:21:03 

# To add the dependency ... go to _____ porm.xml file 

porm.xml 

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>SpringStart</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

</project>













# step 1 ____________________________________________________ define the dependencies 


<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>SpringStart</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

# ........................................................
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.16</version>
        </dependency>
    </dependencies>
# ........................................................

</project>


















# Step 2 ____________ Now You refresh the changes  .... ________________________________

# this will get all the dependencies from you're local repository .... from your central repository __________ try to fetch all the jar files  and it'll create the local repository 


# Now back to the main class .... 
- Spring will create all these particular beans 
- when you start the application , spring will gather all the beans and store in a container .
- So we get all the beans from the container itself 

# So there are two interfaces available that are 
- <a 'BEAN_FACTORY 
- <and 'APPLICATION_CONTEXT  which extends bean_factory so that there are alot more  features in the application context
From this we can use all the beans that are loaded and we can use this particular beans 
- <we don't have to use the 'new keyword to create a new object >




















# step 3 ____________ Now in the main ....... 

src/main/java/demo/main.java 

package demo;

# ____________________________________________
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
# ____________________________________________

public class Main {
    public static void main(String[] args) {

# ____________________________________________
        ApplicationContext context = new ClassPathXmlApplicationContext();
# ____________________________________________

        System.out.println("Hello world!");
  }
}















# Step 4 __________________We need to create the xml configuration since we are using the  ClassPathXmlApplicationContext() 

- What ever is in <the 'src/main/resources folder will be the the 'ClassPath>







# Step 5 ____ create the xml file in the resources folder 

spring.xml 
<?xml version="1.0" encoding="UTF-8" ?> 






# step 6 ___we have to  define the  beans (because all the classes and object will be called beans in spring)
- we can get the particular  beans from <the 'beans_factory or the 'application_context   what every the 'container holding them ..


https://www.baeldung.com/spring-boot-xml-beans  ..... copy and paste in the spring.xml file 

# resources/spring.xml 
<?xml version="1.0" encoding="UTF-8" ?> 
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
 



</beans>








# Step 7 .... within the <beans> we can create more <bean>'s
- <What ever 'classes we will be creating will be defined in here 

<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">


# _____________________________________________________
     <bean id="doctor" class="demo.Doctor"></bean>
# _____________________________________________________



</beans>



# Step 8  _____________ Now get the Doctor class in the main 
src/main/java/demo/main 

package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

# _________________________________________________________
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
# _________________context.getBean() to get a bean defined in the xml ________________________________________

        System.out.println("Hello world!");
    }
}



<Now when we run the app ... we everything works .... 'Dependency_injection by 'xml >









# NB .... we can get the Beans using the id we defined ... but it get's it as an object so it does not  know the type ... so we have to do explicit casting ... 

Doctor doctor = (Doctor)context.getBean("docker");

# or 

Doctor doctor = context.getBean(Doctor.class);















# this is not how we create our applications because of the loads of complex structures   

- Let's say Nurse and doctor belong to staff of hospital

# Create a Staff interface and let Doctor and Nurse implement both ..... 

# staff.java
package demo;

public interface Staff {
     void assist();
}

# doctor.java
package demo;

public class Doctor implements  Staff {
    public void assist(){
        System.out.println("Doctor is assisting");
    }
}

# nurse.java
package demo;

public class Nurse  implements  Staff{
    public void assist(){
        System.out.println("Nurse is assisting");
    }
}

# resources/spring.xml 
<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

     <bean id="doctor" class="demo.Doctor"></bean>
     <bean id="nurse" class="demo.Nurse"></bean>


</beans>



# main.java 

package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
  # ..............
          Staff doctor = context.getBean(Doctor.class);
        Staff nurse =(Nurse)context.getBean("nurse");
  # ................
        doctor.assist();
        nurse.assist();
        System.out.println("Hello world!");
    }
}












# Step 9 ...... Now if the Doctor class had properties not yet defined .... spring will try to set default properties ..... we can do this in the spring.xml file  in the Doctor bean by injecting values to it's properties .... 

# src/main/java/demo/Doctor.java 

package demo;

public class Doctor implements  Staff {
    private String qualification;

    public void assist(){
        System.out.println("Doctor is assisting");
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }
}


# src/main/resources/spring.xml

 <bean id="doctor" class="demo.Doctor">
          <property name="qualification" value="MBMS"></property>
     </bean>

# src/main/java/demo/Main.java 
package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

# ____________________________________________________
          Doctor doctor = context.getBean(Doctor.class);

        System.out.println( doctor.getQualification());
# ____________________________________________________

    }
}


<success>
















# Suppose You wish to inject an entire object itself ...
- Let's add the Nurse object in the Doctor class ... 



# src/main/java/demo/Doctor

package demo;

public class Doctor implements  Staff {
    private String qualification;

    public void assist(){
        System.out.println("Doctor is assisting");
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

        public String getQualification() {
        return qualification;
    }


# ___________________________________________________
    private Nurse nurse;


    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
# ___________________________________________________

}


# src/main/resources/spring.xml 
<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

# ________________________________________
     <bean id="doctor" class="demo.Doctor">
          <property name="qualification" value="MBMS"></property>
# ________________________________________
          <property name="nurse"  ref="Nurse"></property>
# ________________________________________

     </bean>
# ________________________________________

     <bean id="nurse" class="demo.Nurse"></bean>


</beans>













# Let's make the injection in a way that the values are initialized with contructors ... .

# src/main/java/demo/Main.java
package demo;

public class Doctor implements  Staff {
    private String qualification;
# _____________contructor _____________
    public Doctor(String qualification){
        this.qualification = qualification;
    }
# __________________________________________    
    public void assist(){
        System.out.println("Doctor is assisting");
    }
    
    public String getQualification() {
        return qualification;
    }


}

# src/main/resources/spring.xml 











# NB ..... Always create getter's and setters for properties before trying to inject them .... 

