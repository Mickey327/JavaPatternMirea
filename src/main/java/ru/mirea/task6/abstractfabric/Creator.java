package ru.mirea.task6.abstractfabric;

public class Creator {
    private AbstractFurnitureFactory factory;
    public Creator(AbstractFurnitureFactory factory){
        this.factory = factory;
    }
    public void getFurnitureOfThisFactory(){
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        CoffeeTable coffeeTable = factory.createCoffeeTable();
    }
    public Chair getChairOfFactory(){
        return factory.createChair();
    }
    public Sofa getSofaOfFactory(){
        return factory.createSofa();
    }
    public CoffeeTable getCoffeeTableOfFactory(){
        return factory.createCoffeeTable();
    }
    public void setFactory(AbstractFurnitureFactory factory) {
        this.factory = factory;
    }
}
