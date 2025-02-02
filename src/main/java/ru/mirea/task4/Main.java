package ru.mirea.task4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyExecutorService myExecutorService = new MyExecutorService(1);
        myExecutorService.submit(() -> {
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            System.out.println("We run it");
        });
        myExecutorService.submit(() -> System.out.println("Start"));

    }
}
