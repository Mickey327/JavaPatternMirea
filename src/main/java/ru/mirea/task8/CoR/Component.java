package ru.mirea.task8.CoR;

public abstract class Component {
    private Component next;
    public Component linkWith(Component next){
        this.next = next;
        return this;
    }
    public abstract boolean check(String email, String password);
    protected boolean checkNext(String email,String password){
        if (next == null){
            return true;
        }
        return next.check(email,password);
    }
}
