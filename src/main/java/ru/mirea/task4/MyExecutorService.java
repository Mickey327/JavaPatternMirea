package ru.mirea.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class MyExecutorService{
    private List<Thread> threadList;
    private int size;

    public MyExecutorService(int nThreads){
        this.size = nThreads;
        this.threadList = new ArrayList<>();

    }
    public void submit(Runnable runnable) throws InterruptedException {
        if (threadList.size() == size){
            System.out.println("Ждём пока завершится первый запущенный поток, чтобы дать место новому");
            threadList.get(0).join();
            threadList.remove(0);
            System.out.println("Добавляем новый поток");
        }
        Thread thread = new Thread(runnable);
        threadList.add(thread);
        thread.start();

    }
}
