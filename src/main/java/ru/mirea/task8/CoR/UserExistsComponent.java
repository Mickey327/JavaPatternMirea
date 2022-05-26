package ru.mirea.task8.CoR;

public class UserExistsComponent extends  Component {
    private Server server;

    public UserExistsComponent(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)){
            System.out.println("No such email");
            return false;
        }
        if (!server.isValidPassword(email,password)){
            System.out.println("Wrong data");
            return false;
        }
        return checkNext(email, password);
    }
}
