package ru.mirea.task10;

import org.springframework.stereotype.Component;

@Component
public class Junior  implements Programmer{
    @Override
    public void doCoding() {
        System.out.println("It`s junior programmer");
    }
}
