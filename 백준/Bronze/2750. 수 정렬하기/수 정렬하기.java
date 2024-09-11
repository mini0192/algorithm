import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int[] number =  new int[N];
        for(int i = 0; i < N; i++) {
            number[i] = scan.nextInt();
        }
        Arrays.sort(number);

        for(int num : number) {
            System.out.println(num);
        }
    }
}