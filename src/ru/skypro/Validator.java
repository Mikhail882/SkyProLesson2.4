package ru.skypro;

import java.util.Objects;

public class Validator {

    private static final String VALID_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    private Validator() {
    }

    public static boolean check(String login,
                                String password,
                                String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void validate(String login,
                                 String password,
                                 String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20 ) {
            throw new WrongLoginException("����� ������ ������ ���� ������ ��� ����� 20 ��������");
        }
        if (!containsValidSymbols(login)) {
            throw new WrongLoginException("����� �������� ���������� �������");
        }
        if (Objects.isNull(password) || password.length() >= 20 || !containsValidSymbols(password) ||
            Objects.isNull(confirmPassword) || confirmPassword.length() >= 20) {
            throw new WrongPasswordException("����� ������ ������ ���� ������ 20 ��������");
        }
        if (!containsValidSymbols(confirmPassword)) {
            throw new WrongPasswordException("������ �������� ���������� �������");
        }
        if (!password.equals(confirmPassword)) {

            throw new WrongPasswordException("������ ������ ���������!");
        }
    }
    private static boolean containsValidSymbols(String s){
        char[] symbols = s.toCharArray();
         for (char symbol : symbols) {
            if (!VALID_SYMBOLS.contains(String.valueOf(symbol))){
                return false;
                }
            }
                return true;
    }
}






