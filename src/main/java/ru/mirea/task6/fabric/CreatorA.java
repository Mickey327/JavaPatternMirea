package ru.mirea.task6.fabric;

public class CreatorA extends Creator{
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
