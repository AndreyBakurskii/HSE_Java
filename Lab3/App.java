import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО в формате: \"Фамилия_Имя_Отчество\"");
        String fio = scanner.nextLine();

        System.out.println("Введите дату рождения в формате: \"дд.мм.гггг\"");
        String date = scanner.nextLine();

        try {
            Person person = App.parseData(fio, date);
            person.defineAge();
            person.defineSex();

            person.printInfo();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static Person parseData(String fio, String date) throws Exception{

        String[] namePerson = fio.split(" ");
        if (namePerson.length < 3 | namePerson.length > 4){
            throw new Exception("Неправильные введеные данные: ФИО");
        }

        String[] birthdayPerson = date.split(Pattern.quote("."));
        Integer day = Integer.parseInt(birthdayPerson[0]);
        Integer month = Integer.parseInt(birthdayPerson[1]);
        Integer year = Integer.parseInt(birthdayPerson[2]);

        if (day < 1 | day > 31 | month < 1 | month > 12){
            throw new Exception("Неправильные введеные данные: дата рождения!");
        }

        Calendar date_birthday = new GregorianCalendar();
        date_birthday.set(Calendar.YEAR, year);
        date_birthday.set(Calendar.MONTH, month - 1);
        date_birthday.set(Calendar.DAY_OF_MONTH, day);

        if (new GregorianCalendar().getTimeInMillis() - date_birthday.getTimeInMillis() < 0) {
            throw new Exception("Неправильные введеные данные: дата рождения!");
        }

        return new Person(namePerson[1], namePerson[2], namePerson[0], date_birthday);
    }

}
