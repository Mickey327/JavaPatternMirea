package ru.mirea.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = createHumans();
        List<Human> sortedByAgeHumans = humans.stream().sorted(Comparator.comparing(Human::getAge))
                .collect(Collectors.toList());
        System.out.println("Отсортированные по возрасту:");
        sortedByAgeHumans.forEach(System.out::println);
        List<Human> ageLessTwenty = sortedByAgeHumans.stream().filter(x -> x.getAge() < 20)
                .collect(Collectors.toList());
        System.out.println("Меньше 20 лет:");
        ageLessTwenty.forEach(System.out::println);
        List<Human> lastNameContainsE = sortedByAgeHumans.stream().filter(x -> x.getLastName().contains("e"))
                .collect(Collectors.toList());
        System.out.println("Имя содержит букву e:");
        lastNameContainsE.forEach(System.out::println);
        System.out.println("Конкатенация");
        System.out.println(humans.stream().reduce("",(x,y) -> x + y.getLastName().charAt(0)+" ",
                String::concat));
    }
    public static List<Human> createHumans(){
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(21,"Sidorov","Ivan",
                LocalDate.of(2001,02,8),74));
        humanList.add(new Human(22,"Emelyanenko","Andrew",
                LocalDate.of(2000,02,7),73));
        humanList.add(new Human(20,"Ivanov","Peter",
                LocalDate.of(2002,02,9),75));
        humanList.add(new Human(23,"Kerzhakov","Alex",
                LocalDate.of(1999,02,6),72));
        humanList.add(new Human(24,"Bezruchenko","Zahar",
                LocalDate.of(1998,02,5),71));
        return humanList;
    }
}
