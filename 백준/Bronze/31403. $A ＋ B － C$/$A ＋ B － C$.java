import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();

        System.out.print(A + B - C + " ");
        System.out.println(Integer.parseInt("" + A + B) - C);
    }
}