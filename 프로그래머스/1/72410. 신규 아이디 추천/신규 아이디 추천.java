import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        String recommend_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0 ; i<recommend_id.length() ; i++) {
            char now = recommend_id.charAt(i);
            
            if(Character.isLetterOrDigit(now) || now == '_' || now == '-' || now == '.') {
                if(sb.length() > 0) {
                    char before = sb.charAt(sb.length()-1);
                    if(now == '.' && before == '.') {
                        continue;
                    } 
                }
                sb.append(now);
            }  
        }
        
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(sb.length() == 0) {
            sb.append('a');
        }
        
        
        if(sb.length() > 15) {
            if(sb.charAt(14) == '.') {
                sb.setLength(14);
            } else {
                sb.setLength(15);
            }
        }
        

        while(sb.length() < 3) {
            sb.append(sb.charAt(sb.length()-1));
        }

        
        answer = sb.toString();
        return answer;
    }
}