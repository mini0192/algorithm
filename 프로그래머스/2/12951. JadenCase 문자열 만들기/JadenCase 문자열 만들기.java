class Solution {
    public String solution(String s) {
        String[] str = s.split("");
        String rtn = "";
        
        for(int i = 0; i < str.length; i++) {
            if(i == 0) {
                rtn += str[0].toUpperCase();
                continue;
            }
            if(str[i - 1].equals(" "))
                rtn += str[i].toUpperCase();
            else
                rtn += str[i].toLowerCase();
            
        }
        return rtn;
    }
}