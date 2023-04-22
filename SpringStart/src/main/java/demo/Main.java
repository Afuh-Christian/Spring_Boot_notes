package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

          Doctor doctor = context.getBean(Doctor.class);
        Staff nurse =(Nurse)context.getBean("nurse");

        doctor.assist();
        System.out.println( doctor.getQualification());
        nurse.assist();
        System.out.println("Hello world!");
    }
}