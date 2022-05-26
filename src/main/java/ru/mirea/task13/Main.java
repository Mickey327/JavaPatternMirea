package ru.mirea.task13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = context.getBean(Student.class);
        System.out.println(student.getName());
        System.out.println(student.getLastName());
        System.out.println(student.getGroup());
        context.close();

    }
}
