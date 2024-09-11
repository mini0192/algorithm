import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int start = 0;;
        int end = 0;

        int rtn = 0;
        while(end <= N) {
            int sum = 0;
            for(int i = start; i <= end; i++) {
                sum += i;
            }
            if(sum == N) {
                rtn++;
                end++;
            }
            else if(sum > N) start++;
            else end++;
        }

        System.out.println(rtn);
    }
}