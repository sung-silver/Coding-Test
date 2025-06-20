import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        
        while(st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());
            if(current > maxValue) {
                maxValue = current;
            }
            if(current < minValue) {
                minValue = current;
            }
        }
        
        answer = minValue + " " + maxValue;
        
        return answer;
    }
}