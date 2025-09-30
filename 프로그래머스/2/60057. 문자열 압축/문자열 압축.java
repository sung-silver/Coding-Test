import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int step = 1 ; step < s.length() ; step++) {
            String key = "";
            int len = 0;
            int count = 1;
            String compare = s.substring(0, step);
            len += step;
            
            while(len+step <= s.length()) {
                String current = s.substring(len, len+step);
                if(current.equals(compare)) {
                    count++;
                } else {
                    if(count == 1) {
                        key += compare;
                    } else {
                        key += count + compare;
                    }
                    count = 1;
                    compare = current;
                }
                len+=step;
            }
            
            if(count == 1) {
                key += compare;
            } else {
                key += count + compare;
            }
        
            
            if(len < s.length()) {
                key += s.substring(len);
            }
            answer = Math.min(answer, key.length());
        }
        
        return answer;
    }
}