package ru.mirea.task6.fabric;

public class Main {
    public static void main(String[] args) {
        Creator creator = new CreatorA();
        creator.createProduct().doStuff();
        Creator creator2 = new CreatorB();
        creator2.createProduct().doStuff();
    }
}
