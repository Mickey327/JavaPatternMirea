package ru.mirea.task8.State;

public class Test {
    public static void main(String[] args) {
        Player player = new Player();
        System.out.println(player.getState().onPlay());
        System.out.println(player.getState().onNext());
        System.out.println(player.getState().onPrevious());
        System.out.println(player.getState().onLock());
        System.out.println(player.getState().onPrevious());
        System.out.println(player.getState().onPlay());
        System.out.println(player.getState().onPrevious());
    }
}
