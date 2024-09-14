import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            if(a == b && b == c && a == 0) break;
            if(Math.sqrt(a * a + b * b) == c) System.out.println("right");
            else if(Math.sqrt(b * b + c * c) == a) System.out.println("right");
            else if(Math.sqrt(c * c + a * a) == b) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}