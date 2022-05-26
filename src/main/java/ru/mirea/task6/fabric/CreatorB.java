package ru.mirea.task6.fabric;

public class CreatorB extends Creator{
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
