package ru.mirea.task7.proxy;

public class Proxy implements ServiceInterface{
    private Service realService;
    public Proxy(Service realService){
        this.realService = realService;
    }
    public Proxy(){

    }
    @Override
    public void operation(){
        if (realService == null){
            realService = new Service();
        }
        System.out.println("Method call from proxy, redirect to service");
        realService.operation();
    }
}
