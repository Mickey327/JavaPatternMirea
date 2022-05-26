package ru.mirea.task8.CoR;

public class RoleCheckComponent extends Component{
    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")){
            System.out.println("Hello admin");
            return true;
        }
        System.out.println("Hello user");
        return checkNext(email,password);
    }
}
