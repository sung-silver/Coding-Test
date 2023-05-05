import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] hIndex = new Integer[citations.length];
        for(int j=0;j<citations.length;j++){
            hIndex[j] = citations[j];
        }
        
        Arrays.sort(hIndex, Collections.reverseOrder());
        
        for(int i=0;i<citations.length;i++){
            if(i+1<=hIndex[i]){
                answer++;
            }
            else{
                break;
            }
        }
        return answer;
    }
}