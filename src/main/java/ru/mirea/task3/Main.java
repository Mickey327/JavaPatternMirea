package ru.mirea.task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main {
    @Bean
    public List<Integer> listExample(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4;i++){
            list.add(i);
        }
        return list;
    }
    @Bean
    public Set<Integer> setExample(){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4;i++){
            set.add(i);
        }
        return set;
    }
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        List<Integer> list = (List<Integer>) applicationContext.getBean("listExample");
        Set<Integer> set = (Set<Integer>) applicationContext.getBean("setExample");
        Thread thread1 = new Thread(() -> list.add(6));
        Thread thread2 = new Thread(() -> list.add(5));
        thread1.start();
        thread2.start();
        list.stream().forEach(System.out::println);
        Thread thread3 = new Thread(() -> set.add(5));
        Thread thread4 = new Thread(() -> set.add(6));
        thread3.start();
        thread4.start();
        set.stream().forEach(System.out::println);
    }
}
