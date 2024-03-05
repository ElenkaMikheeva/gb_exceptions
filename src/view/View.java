package view;

import dto.User;
import exceptions.CantBeEmptyException;
import exceptions.WrongGender;
import exceptions.WrongPartNumberException;
import model.Writer;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class View {
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public void run() {
        String s = prompt("Введите <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол> разделенные пробелом: ");
        try {
            User user = new User(s);
            Writer w = new Writer();
            w.save(user);
        } catch (WrongPartNumberException | CantBeEmptyException | WrongGender e) {
            System.out.println(e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка разбора даты рождения: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Номер телефона должен содержать только цифры: " + e.getMessage());
        }
    }


}
