package ru.mirea.task6.abstractfabric;

public interface AbstractFurnitureFactory {
    Chair createChair();
    CoffeeTable createCoffeeTable();
    Sofa createSofa();
}
