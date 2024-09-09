import java.util.*;

class Solution {
    class Node {
        int x;
        int cost;
        public Node(int x, int cost) {
            this.x = x;;
            this.cost = cost;
        }
    }

    int answer(int x, int y, int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] check = new boolean[y - x + 1];
        queue.add(new Node(x, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.x == y) return node.cost;
            try {
                if (node.x * 3 <= y && !check[node.x * 3 - x]) {
                    queue.add(new Node(node.x * 3, node.cost + 1));
                    check[node.x * 3 - x] = true;
                }
                if (node.x * 2 <= y && !check[node.x * 2 - x]) {
                    queue.add(new Node(node.x * 2, node.cost + 1));
                    check[node.x * 2 - x] = true;
                }
                if (node.x + n <= y && !check[node.x + n - x]) {
                    queue.add(new Node(node.x + n, node.cost + 1));
                    check[node.x + n - x] = true;
                }
            } catch(Exception e) {}
        }
        return -1;
    }

    int solution(int x, int y, int n) {
        return answer(x, y, n);
    }
}