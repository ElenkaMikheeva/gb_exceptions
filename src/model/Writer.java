package model;

import dto.User;

import java.io.*;

public class Writer {
    private String fileName;

    public void save(User user) {
        this.fileName = String.format("%s.txt", user.getLastName());

        File file = new File(fileName);
        String userData = user.toString();
        if (file.exists()) {
            saveOld(userData);
        } else {
            saveNew(userData);
        }
    }

    public void saveNew(String text) {

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);

        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }
    }

    public void saveOld(String text) {
        String data = readAll() + text;
        saveNew(data);
    }

    private String readAll() {
        StringBuilder stringBuilder = null;

        try (FileReader fReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fReader)) {

            stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.lineSeparator();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            // delete the last new line separator
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (stringBuilder == null) {
            return "";
        }
        return stringBuilder.toString();
    }
}
