import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033[1;36mВведите данные через пробел [Фамилия Имя Отчество дата_рождения номер_телефона пол]: ");
        String input = scanner.nextLine();
        scanner.close();

        try {
            String[] userData = input.split(" ");
            if (userData.length != 4) {
                throw new UserDataException("Неправильное количество данных!");
            }

            String surname = userData[0];
            String name = userData[1];
            String patronymic = userData[2];
            long phoneNumber = Long.parseLong(userData[3]);
    

            String filename = surname + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(surname + " " + name + " " + patronymic + " " + " " + phoneNumber + " ");
            writer.newLine();
            writer.close();
            System.out.println("\033[1;36mДанные успешно записаны в файл: " + filename);
        } catch (UserDataException e) {
            System.out.println("\033[1;31mОшибка: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("\033[1;31mНеправильный формат номера телефона!");
        } catch (IOException e) {
            System.err.println("\033[1;31mОшибка при записи в файл: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\033[1;31mОшибка: Неправильный формат даты рождения!");
        }
    }
}