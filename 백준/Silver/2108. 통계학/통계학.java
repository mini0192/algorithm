import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        int sum = 0;

        // -4000 ~ 4000을 처리하기 위한 배열
        int[] frequency = new int[8001];

        for (int i = 0; i < n; i++) {
            int data = scan.nextInt();
            sum += data;
            arr[i] = data;
            frequency[data + 4000]++;
        }
        
        // 산술평균
        int avg = Math.round((float) sum / n);
        System.out.println(avg);

        // 중앙값
        Arrays.sort(arr);
        int median = arr[n / 2];
        System.out.println(median);

        // 최빈값
        int maxFrequency = 0;
        List<Integer> modes = new ArrayList<>();
        
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                modes.clear();
                modes.add(i - 4000);
            } else if (frequency[i] == maxFrequency) {
                modes.add(i - 4000);
            }
        }
        
        if (modes.size() > 1) {
            Collections.sort(modes);
            System.out.println(modes.get(1));
        } else {
            System.out.println(modes.get(0));
        }

        // 범위
        int range = arr[n - 1] - arr[0];
        System.out.println(range);
    }
}
