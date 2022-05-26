package ru.mirea.task7.composite;

public class Test {
    public static void main(String[] args) {
        Employee emp1=new Developer("John", 10000);
        Employee emp2=new Developer("David", 15000);
        Employee manager1=new Manager("Daniel",25000);
        ((Manager) manager1).add(emp1);
        ((Manager) manager1).add(emp2);
        Employee emp3=new Developer("Michael", 20000);
        Manager generalManager=new Manager("Mark", 50000);
        generalManager.add(emp3);
        generalManager.add(manager1);
        generalManager.print();
        Manager treeManager = new Manager("Tree",10000, new Developer("Antony",30000),
                new Manager("Andrew",15000, new Developer("Jean",35000)));
        treeManager.print();
    }
}
