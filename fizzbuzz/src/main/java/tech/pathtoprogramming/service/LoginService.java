package tech.pathtoprogramming.service;

public class LoginService {

    public String login(String username) {
        if (username.equals("Warren")) {
            throw new IllegalArgumentException();
        }
        return "Success";
    }
}
