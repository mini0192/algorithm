import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;

        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += scan.nextInt();
            if(sum <= 100) num1 = sum;
            else if(num2 == 0) num2 = sum;
        }

        if(num2 == 0) {
            System.out.println(num1);
            return;
        }

        int check1 = 100 - num1;
        int check2 = num2 - 100;

        if(check1 >= check2) System.out.println(num2);
        else System.out.println(num1);
    }
}