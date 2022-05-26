package ru.mirea.task10;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer{
    @Override
    public void doCoding() {
        System.out.println("It`s middle programmer");
    }
}
