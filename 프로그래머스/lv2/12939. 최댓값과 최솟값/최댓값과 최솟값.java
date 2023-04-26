import java.util.ArrayList;
class Solution {
    public String solution(String s) {
        String answer = "";
        String []number = s.split(" ");
        int length = s.length();
        ArrayList<Integer> list = new ArrayList<>(length);
        for(int i=0;i<length;i++){
            
        }
        answer = Collections.min(list)+" "+Collections.max(list);
        
        return answer;
    }
}