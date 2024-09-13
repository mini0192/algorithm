import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        AtomicInteger sum = new AtomicInteger();
        Stream.of(br.readLine().split(" ")).forEach(s -> {
            int data = Integer.parseInt(s);
            sum.addAndGet(data * data);
        });
        
        System.out.println(sum.get() % 10);
    }
}