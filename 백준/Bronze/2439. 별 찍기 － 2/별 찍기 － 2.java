import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();

        for(int i = 0; i < A; i++) {
            for(int j = A - 1; j >= 0; j--) {
                if(j > i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
}