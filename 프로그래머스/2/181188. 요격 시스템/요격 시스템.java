import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // end 기준 오름차순
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int curEnd = -1;
        
        // target 기준 탐색
        for(int[] target : targets) {
            if(curEnd == -1) {
                answer++;
                curEnd = target[1];
            }
            
            if(target[0] < curEnd) {
                continue;
            }
            
            answer++;
            curEnd = target[1];
        }
        
        return answer;
    }
}