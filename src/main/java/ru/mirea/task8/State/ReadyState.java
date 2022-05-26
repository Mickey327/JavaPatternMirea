package ru.mirea.task8.State;

public class ReadyState extends State{

    ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return "Locking";
    }

    @Override
    public String onPlay() {
        player.changeState(new PlayingState(player));
        return "Start playing music";
    }

    @Override
    public String onNext() {
        return "It`s ready but not playing";
    }

    @Override
    public String onPrevious() {
        return "It`s ready but not playing";
    }
}
