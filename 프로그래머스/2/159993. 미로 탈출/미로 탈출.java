import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class NodeClass {
        public int cost;
        public int[] position;

        public NodeClass(int cost, int[] position) {
            this.cost = cost;
            this.position = position;
        }
    }

    int[] start;
    int[] lever;
    int[] exit;

    int time;

    boolean[][] makeBooleanMap(String[] maps) {
        boolean[][] mapBoolean = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                char check = maps[i].charAt(j);

                if(check == 'X') mapBoolean[i][j] = true;
                else if(check == 'S') start = new int[]{i, j};
                else if(check == 'L') lever = new int[]{i, j};
                else if(check == 'E') exit = new int[]{i, j};
            }
        }
        return mapBoolean;
    }

    int findCost(Queue<NodeClass> queue, boolean[][] map, int[] target) {
        int cost = -1;
        while(!queue.isEmpty()) {
            time++;
            NodeClass node = queue.poll();
            int[] position;

            if(node.position[0] == target[0] && node.position[1] == target[1]) {
                cost = node.cost;
                break;
            }

            position = new int[]{node.position[0] - 1, node.position[1]};
            if(position[0] >= 0 && !map[position[0]][position[1]]) {
                queue.add(new NodeClass(node.cost + 1, position));
                map[position[0]][position[1]] = true;
            }

            position = new int[]{node.position[0], node.position[1] - 1};
            if(position[1] >= 0 && !map[position[0]][position[1]]) {
                queue.add(new NodeClass(node.cost + 1, position));
                map[position[0]][position[1]] = true;
            }

            position = new int[]{node.position[0], node.position[1] + 1};
            if(position[1] < map[0].length && !map[position[0]][position[1]]) {
                queue.add(new NodeClass(node.cost + 1, position));
                map[position[0]][position[1]] = true;
            }

            position = new int[]{node.position[0] + 1, node.position[1]};
            if(position[0] < map.length && !map[position[0]][position[1]]) {
                queue.add(new NodeClass(node.cost + 1, position));
                map[position[0]][position[1]] = true;
            }
        }

        return cost;
    }

    public int solution(String[] maps) {
        time = 0;
        boolean[][] map = makeBooleanMap(maps);
        Queue<NodeClass> queue = new LinkedList<>();
        int leverCost;
        int exitCost;

        queue.add(new NodeClass(0, start));
        leverCost = findCost(queue, map, lever);
        if(leverCost == -1) return -1;

        queue.clear();
        map = makeBooleanMap(maps);

        queue.add(new NodeClass(0, lever));
        exitCost = findCost(queue, map, exit);
        if(exitCost == -1) return -1;

        return leverCost + exitCost;
    }
}