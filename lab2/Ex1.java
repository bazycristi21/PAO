import java.util.Scanner;

public class Exemplul1 {
    public static void main(String[] args)
    {
        int[] studentsAge = new int[25];
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int i;
        for(i = 0; i <  studentsAge.length; i++)
        {
            int value = scanner.nextInt();
            if(value == -1)
            {
                break;
            }
            else
            {
                studentsAge[i] = value;
                sum += value;
            }
        }
        System.out.println("The grades average is:" + sum / i);
    }
}
