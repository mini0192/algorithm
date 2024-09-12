import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int X = scan.nextInt();

        int[] visit = new int[N];

        visit[0] = scan.nextInt();
        for(int i = 1; i < N; i++) {
            visit[i] = visit[i - 1] + scan.nextInt();
        }

        int max = 0;
        int num = 0;

        for(int i = 0; i < N - X + 1; i++) {
            int a = visit[X + i - 1];
            int b = i == 0 ? 0 : visit[i - 1];

            int sub = a - b;
            if(max < sub) {
                max = sub;
                num = 1;
            }
            else if(max == sub) {
                num++;
            }
        }

        if(max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(num);
        }
    }
}