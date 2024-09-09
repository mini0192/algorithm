import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String get = scan.next();
        String[] getArr = get.split("");
        
        Map<String, Integer> check = new HashMap<>();
        
        for(String d : getArr) {
            String str = d.toUpperCase();
            if(check.containsKey(str)) {
                int getMap = check.get(str) + 1;
                check.put(str, getMap);
            } else check.put(str, 1);
        }
        
        int max = 0;
        String rtn = "?";
        boolean status = false;
        for(Map.Entry<String, Integer> e : check.entrySet()) {
            if(e.getValue() > max) {
                rtn = e.getKey();
                max = e.getValue();
                status = false;
            }
            else if(e.getValue() == max) status = true;
        }
        
        if(status) System.out.println("?");
        else System.out.println(rtn);
    }
}