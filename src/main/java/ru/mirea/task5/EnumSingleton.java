package ru.mirea.task5;

public enum EnumSingleton {

    INSTANCE("Initial class info");

    private String info;

    private EnumSingleton(String info) {
        this.info = info;
    }

    public static synchronized EnumSingleton getInstance() {
        return INSTANCE;
    }
}
