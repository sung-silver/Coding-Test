import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for(int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
        
        for(int i = 0 ; i < topping.length - 1 ; i++) {
            int now = topping[i];
            left.put(now, left.getOrDefault(now, 0) + 1);
            right.put(now, right.get(now) - 1);
            if(right.get(now) == 0) {
                right.remove(now);
            }
            
            if(left.size() == right.size()) {
                answer++;
            }
        }
           
        return answer;
    }
}