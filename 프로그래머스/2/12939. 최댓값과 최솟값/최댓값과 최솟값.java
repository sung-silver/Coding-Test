import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String com : arr) {
            int current = Integer.valueOf(com);
            if(current > max) {
                max = current;
            }
            if(current < min) {
                min = current;
            }
        }
        String answer = min + " " + max;
        return answer;
    }
}