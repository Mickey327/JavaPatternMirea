package ru.mirea.task10;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("It`s senior programmer");
    }
}
