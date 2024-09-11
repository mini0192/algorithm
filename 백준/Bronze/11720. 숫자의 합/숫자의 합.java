import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        String str = scan.next();
        char[] number = str.toCharArray();

        int sum = 0;
        for(char num : number) {
            sum += num - '0';
        }

        System.out.println(sum);
    }
}