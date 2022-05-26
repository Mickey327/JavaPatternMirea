package ru.mirea.task7.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Manager implements Employee{
    private String name;
    private int salary;
    private List<Employee> controlledEmployees = new ArrayList<>();
    @Override
    public String getName() {
        return this.name;
    }
    public Manager(String name, int salary, Employee ... employees){
        this.name = name;
        this.salary = salary;
        controlledEmployees.addAll(Arrays.asList(employees));
    }
    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void print() {
        System.out.println("Name: " + this.name + ", salary: " + this.salary);
        Iterator employeeIterator = controlledEmployees.iterator();
        while (employeeIterator.hasNext()){
            Employee employee = (Employee) employeeIterator.next();
            employee.print();
        }
    }
    public Employee getChild(int i){
        return controlledEmployees.get(i);
    }
    public void add(Employee employee){
        controlledEmployees.add(employee);
    }
    public void remove(Employee employee){
        controlledEmployees.remove(employee);
    }
}
