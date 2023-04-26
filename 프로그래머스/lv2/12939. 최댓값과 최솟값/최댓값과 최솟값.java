import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        int max = Integer.MIN_VALUE; // int형의 최소값
        int min = Integer.MAX_VALUE; // int형의 최대값
        int com;

        for(int i=0 ;i< numbers.length;i++){
            com = Integer.valueOf(numbers[i]);
            min = Math.min(min, com);
            max = Math.max(max, com);
        }
        
        answer = min+" "+max;
        
        return answer;
    }
}