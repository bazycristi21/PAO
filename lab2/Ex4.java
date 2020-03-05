package pachet;

public class Subject {
    private Room room;
    private int noOfStundents;
    private Person teacher;

    public Subject(Room room, int noOfStundents, Person teacher) {
        this.room = room;
        this.noOfStundents = noOfStundents;
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNoOfStundents() {
        return noOfStundents;
    }

    public void setNoOfStundents(int noOfStundents) {
        this.noOfStundents = noOfStundents;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
}

package pachet;
import java.util.Scanner;

public class Main {

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);

        Room R1 = new Room("12A","normal",3);
        Room R2 = new Room("12B","tech",7);



        Person P1 = new Person();
        P1.setType("teacher");
        P1.setName("John");
        Person P2 = new Person();
        P2.setType("teacher");
        P2.setName("Jane");

        Subject S1 = new Subject(R1,25,P1);
        Subject S2 = new Subject(R2,25,P2);

        System.out.print(S1.getRoom().getNumber());
        System.out.print(S1.getRoom().getType());
        System.out.print(S1.getRoom().getFloor());
        System.out.print(S1.getNoOfStundents());
        System.out.println(S1.getTeacher().getName());
        System.out.print(S2.getRoom().getNumber());
        System.out.print(S2.getRoom().getType());
        System.out.print(S2.getRoom().getFloor());
        System.out.print(S2.getNoOfStundents());
        System.out.print(S2.getTeacher().getName());

    }
}

