package ru.mirea.task6.builder;

public class Test {
    public static void main(String[] args) {
        User user = new User.UserBuilder("Patrick","Bateman")
                .age(30)
                .phone("+79023673423")
                .address("st.Pushkina")
                .build();
        User user2 = new User.UserBuilder("Ryan","Gosling")
                .age(27)
                .build();
        System.out.println(user);
        System.out.println(user2);
    }
}
