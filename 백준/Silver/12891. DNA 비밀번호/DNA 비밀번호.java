import java.util.Scanner;

public class Main {

    static int a = 0;
    static int c = 0;
    static int g = 0;
    static int t = 0;

    static int A;
    static int C;
    static int G;
    static int T;

    static char[] pass;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int S = scan.nextInt();
        int P = scan.nextInt();

        String password = scan.next();
        pass = password.toCharArray();

        A = scan.nextInt();
        C = scan.nextInt();
        G = scan.nextInt();
        T = scan.nextInt();

        int rtn = 0;

        for(int i = 0; i < P; i++) {
            add(pass[i]);
        }

        if(check()) rtn++;

        for(int i = P; i < S; i++) {
            sub(pass[i - P]);
            add(pass[i]);

            if(check()) rtn++;
        }

        System.out.println(rtn);
    }
    private static void add(char data) {
        if(data == 'A') a++;
        else if(data == 'C') c++;
        else if(data == 'G') g++;
        else if(data == 'T') t++;
    }

    private static void sub(char data) {
        if(data == 'A') a--;
        else if(data == 'C') c--;
        else if(data == 'G') g--;
        else if(data == 'T') t--;
    }

    private static boolean check() {
        if(a < A) return false;
        if(c < C) return false;
        if(g < G) return false;
        if(t < T) return false;

        return true;
    }
}