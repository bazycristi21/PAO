import java.util.Scanner;
public class Ex2{
 public static void main(String[] args)
 {
     Scanner input = new Scanner(System.in);
     int n = input.nextInt();
     int sum = 0;
     for(int i = 0; i <= n ;i++)
     {
         if(i%3 == 0 || i%5 == 0)
         {
             sum += i;
         }
     
    }
    System.out.print(sum);
}
}
