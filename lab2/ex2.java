package pachet;


class Person {
    private String name;
    private String surname;
    private String age;
    private Long idNo;
    private String type;

    public Person() {
        this.type = "student";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


package pachet;
import java.util.Scanner;

public class Main {

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);

        Person P1 = new Person();
        P1.setName("John");
        P1.setSurname("Doe");
        P1.setAge("24");
        P1.setIdNo(1123444L);

        Person P2 = new Person();
        P2.setName("Jane");
        P2.setSurname("Roe");
        P2.setAge("56");
        P2.setIdNo(2233444L);
        P2.setType("teacher");

        System.out.println(P1.getName());
        System.out.println(P1.getSurname());
        System.out.println(P1.getAge());
        System.out.println(P1.getIdNo());
        System.out.println(P1.getType());
    }
}
