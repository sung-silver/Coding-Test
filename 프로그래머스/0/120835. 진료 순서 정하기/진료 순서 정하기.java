import java.util.*;

class Solution {

    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Integer[] sorted = Arrays.stream(emergency)
                         .boxed()
                         .sorted(Collections.reverseOrder())
                         .toArray(Integer[]::new);
        
        for(int i=0 ; i<emergency.length ; i++) {
            for(int j=0; j<emergency.length ; j++) {
                if(emergency[i] == sorted[j]) {
                    answer[i] = j+1;
                }
            }
        }
        
        return answer;
    }
}