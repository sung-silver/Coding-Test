import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder sb = new StringBuilder();
            String compare = s.substring(0, step);
            int count = 1;
            
            for (int i = step; i < s.length(); i += step) {
                int end = Math.min(i + step, s.length());
                String current = s.substring(i, end);
                
                if (current.equals(compare)) {
                    count++;
                } else {
                    sb.append(count == 1 ? "" : count).append(compare);
                    compare = current;
                    count = 1;
                }
            }
            
            sb.append(count == 1 ? "" : count).append(compare);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
