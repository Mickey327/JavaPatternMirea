package ru.mirea.task7.proxy;

public class Service implements ServiceInterface{
    public Service(){

    }
    @Override
    public void operation() {
        System.out.println("This is real Service method call");
    }
}
