package pachet;

public class Room {
    private String number;
    private String type;
    private int floor;

    public Room(String number, String type, int floor) {
        this.number = number;
        this.type = type;
        this.floor = floor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
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

        System.out.print(R1.getNumber());
        System.out.print(R1.getType());
        System.out.println(R1.getFloor());
        System.out.print(R2.getNumber());
        System.out.print(R2.getType());
        System.out.print(R2.getFloor());

    }
}

