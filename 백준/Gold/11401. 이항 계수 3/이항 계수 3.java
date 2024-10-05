import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        long N = Long.parseLong(line[0]);
        long K = Long.parseLong(line[1]);

        if (K < 0 || K > N) {
            System.out.println(0);
            return;
        }
        if (N == 0 || N == K) {
            System.out.println(1);
            return;
        }

        long nFactorial = calculateFactorial(N);
        long kFactorial = calculateFactorial(K);
        long nMinusKFactorial = calculateFactorial(N - K);

        long kInverse = modInverse(kFactorial, MOD);
        long nMinusKInverse = modInverse(nMinusKFactorial, MOD);

        long result = (nFactorial * kInverse % MOD) * nMinusKInverse % MOD;
        System.out.println(result);
    }

    private static long calculateFactorial(long num) {
        long rtn = 1;
        for (long i = 2; i <= num; i++) {
            rtn = (rtn * i) % MOD;
        }
        return rtn;
    }

    private static long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    private static long power(long x, long y, long mod) {
        long result = 1;
        x = x % mod;
        while (y > 0) {
            if ((y & 1) == 1) {
                result = (result * x) % mod;
            }
            y = y >> 1;
            x = (x * x) % mod;
        }
        return result;
    }
}
