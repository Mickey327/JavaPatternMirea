package ru.mirea.task5;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        System.out.println("ClassSingleton:");
        for (int i = 0; i < 2; i++) {
            System.out.println(ClassSingleton.getInstance() == ClassSingleton.getInstance());
        }
        System.out.println();
        System.out.println("EnumSingleton:");
        for (int i = 0; i < 2; i++) {
            System.out.println(EnumSingleton.getInstance() == EnumSingleton.getInstance());
        }
        System.out.println();
        System.out.println("InnerClassSingleton:");
        for (int i = 0; i < 2; i++) {
            System.out.println(InnerClassSingleton.getInstance() == InnerClassSingleton.getInstance());
        }
        System.out.println();
    }
}
