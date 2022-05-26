package ru.mirea.task8.CoR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;
    private static void initialize(){
        server = new Server();
        server.register("admin@example.com","admin_pass");
        server.register("user@example.com","user_pass");
        Component component = new ThrottlingComponent(2);
        component.linkWith(new UserExistsComponent(server)).linkWith(new RoleCheckComponent());
        server.setComponent(component);
    }

    public static void main(String[] args) throws IOException {
        initialize();
        boolean isSuccess;
        do{
            System.out.println("Enter email");
            String email = reader.readLine();
            System.out.println("Enter password");
            String password = reader.readLine();
            isSuccess = server.logIn(email, password);
        }while(!isSuccess);
    }
}
