package src.main.java.com.springboot.security.service;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String role);

    SignResultDto signIn(String id, String password) throws RuntimeException;
}
