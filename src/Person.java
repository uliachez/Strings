import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    private String FIO;
    private LocalDate date;

    public Person(String FIO, String date) throws Exception {
        this.FIO = FIO;
        this.date = parseDate(date);
    }

    private LocalDate parseDate(String date) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        try {
            return LocalDate.parse(date, formatter);
        }
        catch (DateTimeParseException e) {
            throw new Exception("Неверный формат даты. Используйте 'дд.мм.гггг'");
        }
    }

    public String getInitials() {
        String[] parts = FIO.split(" ");
        return parts[0] + " " + parts[1].charAt(0) + "." + parts[2].charAt(0) + ".";
    }

    public String getGender() {
        String[] parts = FIO.split(" ");
        String second_name = parts[2];
        if ((second_name.endsWith("вич")) || (second_name.endsWith("ич"))) {
            return "М";
        }
        else if ((second_name.endsWith("вна")) || (second_name.endsWith("чна"))) {
            return "Ж";
        }
        else {
            return "Неудалось опредилить пол";
        }
    }

    public int getAge() {
        return LocalDate.now().getYear() - date.getYear();
    }

    public String endingAge() {
        int age = getAge();
        String ending;
        if (age % 10 == 1 && age % 100 != 11) {
            ending = "год";
        }
        else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
            ending = "года";
        }
        else {
            ending = "лет";
        }
        return age + " " + ending;
    }
}
