import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private String firstname, middlename, lastname, sex;
    private Calendar date_birthday;
    private long age;

    public Person(String fname, String mname, String lname, Calendar date) {
        this.firstname = fname;
        this.middlename = mname;
        this.lastname = lname;
        this.date_birthday = date;
    }

    public void printInfo(){
        System.out.printf("%s %c.%c.\n%s\n%d", this.lastname,
                                               this.firstname.charAt(0),
                                               this.middlename.charAt(0),
                                               this.sex,
                                               this.age);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public long getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void defineSex() {
        if (middlename.charAt(middlename.length() - 1) == 'а'){
            this.sex = "Женский";
        }else {
            this.sex = "Мужской";
        }
    }

    public void defineAge() {
        Calendar date = new GregorianCalendar();
        this.age = date.getTimeInMillis() - this.date_birthday.getTimeInMillis() / 1000 / 60 / 60 / 24 / 365;
    }
}
