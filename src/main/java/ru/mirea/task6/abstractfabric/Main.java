package ru.mirea.task6.abstractfabric;

public class Main {
    public static void main(String[] args) {
        Creator creator = new Creator(new VictorianFurnitureFactory());
        System.out.println(creator.getChairOfFactory().getName());
        System.out.println(creator.getSofaOfFactory().getName());
        System.out.println(creator.getCoffeeTableOfFactory().getName());
        System.out.println("Changing factory to Modern");
        creator.setFactory(new ModernFurnitureFactory());
        System.out.println(creator.getChairOfFactory().getName());
        System.out.println(creator.getSofaOfFactory().getName());
        System.out.println(creator.getCoffeeTableOfFactory().getName());
    }
}
