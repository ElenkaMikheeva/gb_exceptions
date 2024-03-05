package dto;

import exceptions.CantBeEmptyException;
import exceptions.WrongGender;
import exceptions.WrongPartNumberException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class User {
    String lastName;
    String firstName;
    String middleName;
    LocalDate birthday;
    Integer phone;
    String gender;

    public User(String s) throws DateTimeParseException, NumberFormatException {
        String[] parts = s.split(" ");
        if (parts.length != 6) {
            throw new WrongPartNumberException(6, parts.length);
        }
        if (parts[0].isEmpty()){
            throw new CantBeEmptyException("Фамилия не может быть пустой");
        }
        lastName = parts[0];

        if (parts[1].isEmpty()){
            throw new CantBeEmptyException("Имя не может быть пустым");
        }
        firstName = parts[1];

        if (parts[2].isEmpty()){
            throw new CantBeEmptyException("Отчество не может быть пустым");
        }
        middleName = parts[2];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        birthday = LocalDate.parse(parts[3], formatter);

        phone = Integer.parseInt(parts[4]);

        if (!parts[5].equals("f")  && !parts[5].equals("m")){
            throw new WrongGender("Пол обозначается буквой f или m");
        }
        gender = parts[5];
    }

    @Override
    public String toString(){
        return  lastName + " " +
        firstName + " " +
        middleName + " " +
        birthday + " " +
        phone + " " +
        gender;
    }

    public String getLastName() {
        return lastName;
    }
}
