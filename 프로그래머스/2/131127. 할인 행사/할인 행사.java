class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;
        for(int i = 0; i < discount.length - 9; i++) {
            int[] num = number.clone();
            
            String[] target = new String[10];
            for(int j = 0; j < 10; j++) {
                target[j] = discount[i + j];
            }
            
            for(int j = 0; j < want.length; j++) {
                String check = want[j];
                for(String t : target) {
                    if(check.equals(t) && num[j] > 0) {
                        num[j]--;
                    }
                }
            }
            
            boolean check = true;
            for(int n : num) {
                if(n != 0) {
                    check = false;
                    break;
                }
            }
            if(check) count++;
        }
        return count;
    }
}