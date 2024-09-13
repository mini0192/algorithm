import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int index;
    private int value;

    public Node(int index, int value) {
        super();
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return this.index;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] node = new Node[N];
        for(int i = 0; i < N; i++) {
            node[i] = new Node(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(node);

        int max = 0;
        for(int i = 0; i < N; i++) {
            int index = node[i].getIndex();
            max = Math.max(max, index - i);
        }

        System.out.println(max + 1);
    }
}