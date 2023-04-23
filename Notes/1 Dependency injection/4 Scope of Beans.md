# The different scopes of the beans    00:37:59.987 

# When spring creates a beans , we need to define how does beans we want ... there are 5 different scopes we want ... 
- By default all the beans are created in the singleton scope ... so for each class , there will be only one single object available for the entire application  

# There are 5 different scopes 
- SINGLETON
- PROTOTYPE 
- REQUEST 
- SESSION 
- GLOBAL SESSION 


# NB ...request , session and global session are used mainly when there is a web context available (when we are implementing the spring mvc )



# SINGLETON  --------------------------------------------
Always result into one  particular object in the entire application 
- Is used when you need one object or you need a different object for each and every request that you recieve in the application


# demo/Doctor 

package demo;

import org.springframework.stereotype.Component;


public class Doctor implements  Staff {

 # ..........this will make us to be able to sout(doctor) ....
    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }
# ..................................

    private String qualification;
    public void assist(){
        System.out.println("Doctor is not more assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}

# demo/Main 

package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
# create an object
        Doctor doctor = context.getBean(Doctor.class);
        doctor.setQualification("MMMMM");
        System.out.println(doctor);

# create another object but still refers to the first object
        Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor);

    }
}





# The default scope of the Doctor class is singleton 

# demo/Doctor
import org.springframework.context.annotation.Scope;

@Scope(scopeName = "singleton")
public class Doctor implements  Staff {}








# PROTOTYPE ---------------------------------------------
You get a different object everytime you request the object from the container


# Here we change the scope type of the doctor class and for this to work we have to make Doctor a component ... 
import org.springframework.context.annotation.Scope;

@Component 
@Scope(scopeName = "prototype")
public class Doctor implements  Staff {}



# full prototype code ..... 

# demo/Doctor 
package demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Doctor implements  Staff {

    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    private String qualification;
    public void assist(){
        System.out.println("Doctor is not more assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}

# ---------------------------------


# demo/BeanConfig 
package demo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {

}

# ---------------------------------

# demo/Main 

package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Doctor doctor = context.getBean(Doctor.class);
        doctor.setQualification("MMMMM");
        System.out.println(doctor);

        Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor1);

    }
}
# --------------------------



# We see that the outputs are different .... 