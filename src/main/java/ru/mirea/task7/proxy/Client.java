package ru.mirea.task7.proxy;

public class Client {
    public static void main(String[] args) {
        ServiceInterface proxy = new Proxy();
        proxy.operation();
        ServiceInterface proxyWithInitialization = new Proxy(new Service());
        ServiceInterface service = new Service();
        proxyWithInitialization.operation();
        service.operation();
    }
}
