package ru.skypro;

public class Main {

    public static void main(String[] args) {
        boolean result = Validator.check("test1234", "passEWF123", "passEWF123");
        if (result) {
            System.out.println("����� � ������ ���������");
        }else{
            System.out.println("����� �/��� ������ �� ���������");
        }
    }
}
