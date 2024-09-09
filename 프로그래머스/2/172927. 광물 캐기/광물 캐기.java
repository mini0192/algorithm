import java.util.*;

class Solution {
    private Map<String, Integer> makeCostMap(int pick) {
        Map<String, Integer> cost = new HashMap<>();

        switch(pick) {
            case 0:
                cost.put("diamond", 1);
                cost.put("iron", 1);
                cost.put("stone", 1);
                break;
            case 1:
                cost.put("diamond", 5);
                cost.put("iron", 1);
                cost.put("stone", 1);
                break;
            case 2:
                cost.put("diamond", 25);
                cost.put("iron", 5);
                cost.put("stone", 1);
                break;
        }

        return cost;
    }

    private int encryption(String[] arr) {
        int cost = 0;

        for(String s : arr) {
            if(s == null) break;
            switch (s) {
                case "diamond":
                    cost += 100;
                    break;
                case "iron":
                    cost += 10;
                    break;
                case "stone":
                    cost += 1;
                    break;
            }
        }
        return cost;
    }

    private int decryption(int num, Map<String, Integer> costs) {
        int cost = 0;

        cost += (num / 100) * costs.get("diamond");
        num %= 100;

        cost += (num / 10) * costs.get("iron");
        num %= 10;

        cost += num * costs.get("stone");

        return cost;
    }

    public int solution(int[] picks, String[] minerals) {
        int cost = 0;
        int pickSum = picks[0] + picks[1] + picks[2];
        int i = 0;
        List<Integer> mineralsCost = new ArrayList<>();

        while(true) {
            int arrLow = i * 5;

            if(arrLow > minerals.length) break;
            if(i >= pickSum) break;

            mineralsCost.add(encryption(Arrays.copyOfRange(minerals, arrLow, arrLow+5)));
            i++;
        }

        Collections.sort(mineralsCost, Collections.reverseOrder());

        for(int mineral : mineralsCost) {
            if(picks[0] > 0) {
                cost += decryption(mineral, makeCostMap(0));
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                cost += decryption(mineral, makeCostMap(1));
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                cost += decryption(mineral, makeCostMap(2));
                picks[0]--;
                continue;
            }
        }

        return cost;
    }
}