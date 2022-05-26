package ru.mirea.task8.State;

public class PlayingState extends State{

    PlayingState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        return "Paused";
    }

    @Override
    public String onNext() {
        return "Setting next track";
    }

    @Override
    public String onPrevious() {
        return "Setting previous track";
    }
}
