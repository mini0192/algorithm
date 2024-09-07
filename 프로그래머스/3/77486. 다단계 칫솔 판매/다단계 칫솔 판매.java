import java.util.*;

class Solution {
    
    private Map<Integer, Integer> memberMap = new HashMap<>();
    private Map<String, Integer> memberInfo = new HashMap<>();
    private int[] globalRtn;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        globalRtn = new int[enroll.length];
        createMemberAndOrderMap(enroll, referral);
        
        for(int i = 0; i < seller.length; i++) {
            int sell = memberInfo.get(seller[i]);
            int price = amount[i] * 100;
            
            priceForCenter(sell, price);
        }
        
        return globalRtn;
    }
    
    // 맴버와 맴버의 order(?) 맵을 만드는 부분
    private void createMemberAndOrderMap(String[] enroll, String[] referral) {
        for(int i = 0; i < enroll.length; i++) {
            memberInfo.put(enroll[i], i);
            
            int orderMember = referral[i].equals("-") ? -1 : memberInfo.get(referral[i]);
            memberMap.put(i, orderMember);
        }
    }
    
    // 개개인에게 떨어지는 금액을 만드는 메서드
    private void priceForCenter(int sell, int price) {
        if(sell == -1) return;
        
        int givePrice = (int) (price * 0.1);
        globalRtn[sell] += price - givePrice;
        
        if(givePrice < 1) return;
        
        int order = memberMap.get(sell);
        priceForCenter(order, givePrice);
    }
}