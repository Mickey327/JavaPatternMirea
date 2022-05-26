package ru.mirea.task8.State;

public class LockedState extends State{
    LockedState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        return "It`s already locked";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready to start";
    }

    @Override
    public String onNext() {
        return "Locked";
    }

    @Override
    public String onPrevious() {
        return "Locked";
    }
}
