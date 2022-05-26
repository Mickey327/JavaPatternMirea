package ru.mirea.task1;

import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = x -> {
            char[] chars = x.toCharArray();
            for (int i = 2; i < chars.length; i+=3){
                chars[i] = Character.toUpperCase(chars[i]);
            }
            x = String.valueOf(chars);
            System.out.println(x);
        };
        Scanner sc = new Scanner(System.in);
        stringConsumer.accept(sc.nextLine());
    }
}
