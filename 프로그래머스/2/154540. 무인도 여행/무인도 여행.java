import java.util.*;

class Solution {
    class NodeClass {
        public int days;
        public int[] island;

        public NodeClass(int days, int[] island) {
            this.days = days - '0';
            this.island = island;
        }
    }

    private void makeMap(String[] maps) {
        for (int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] != 'X') checkMap[i][j] = true;
            }
        }
    }

    private int[] findIsland(boolean[][] map) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1};
    }

    boolean[][] checkMap;
    char[][] map;

    private int checkIsland(Stack<NodeClass> stack) {
        int maxDay = 0;
        while(!stack.isEmpty()) {
            NodeClass node = stack.pop();

            int x = node.island[1];
            int y = node.island[0];

            maxDay += node.days;
            int checkX;
            int checkY;

            checkY = y - 1;
            checkX = x;
            if(checkY >= 0 && checkMap[checkY][checkX]) {
                stack.push(new NodeClass(map[checkY][checkX], new int[]{checkY, checkX}));
                checkMap[checkY][checkX] = false;
            }

            checkY = y;
            checkX = x - 1;

            if(checkX >= 0 && checkMap[checkY][checkX]) {
                stack.push(new NodeClass(map[checkY][checkX], new int[]{checkY, checkX}));
                checkMap[checkY][checkX] = false;
            }

            checkX = x + 1;
            checkY = y;
            if(checkX < checkMap[0].length && checkMap[checkY][checkX]) {
                stack.push(new NodeClass(map[checkY][checkX], new int[]{checkY, checkX}));
                checkMap[checkY][checkX] = false;
            }

            checkX = x;
            checkY = y + 1;
            if(checkY < checkMap.length && checkMap[checkY][checkX]) {
                stack.push(new NodeClass(map[checkY][checkX], new int[]{checkY, checkX}));
                checkMap[checkY][checkX] = false;
            }
        }

        return maxDay;
    }

    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        checkMap = new boolean[maps.length][maps[0].length()];
        makeMap(maps);

        List<Integer> days = new ArrayList<>();

        while(true) {
            int[] island = findIsland(checkMap);
            if(island[0] == -1) break;

            checkMap[island[0]][island[1]] = false;

            Stack<NodeClass> stack = new Stack<>();
            stack.push(new NodeClass(map[island[0]][island[1]], island));

            days.add(checkIsland(stack));
        }

        if(days.isEmpty()) return new int[]{-1};

        Collections.sort(days);

        return days.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}