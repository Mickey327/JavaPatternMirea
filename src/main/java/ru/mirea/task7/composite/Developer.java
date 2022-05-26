package ru.mirea.task7.composite;

public class Developer implements Employee{
    private String name;
    private int salary;
    public Developer(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void print() {
        System.out.println("Name: " + this.name + ", salary: " + this.salary);
    }
}
