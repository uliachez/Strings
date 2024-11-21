import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Введите ФИО: ");
            String FIO = scan.nextLine();

            System.out.println("Введите дату рождения (дд.мм.гггг): ");
            String date = scan.nextLine();

            Person person = new Person(FIO, date);

            System.out.println("Инициалы: " + person.getInitials());
            System.out.println("Пол: " + person.getGender());
            System.out.println("Возраст: " + person.endingAge());
        }
        catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        finally {
            scan.close();
        }
    }
}