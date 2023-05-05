import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int remain = 0;
        Queue<Integer> clear = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        
        // 남은 작업량 / 속도 = 남은 일수
        for(int i=0;i<progresses.length;i++){
            remain = 100-progresses[i];
            clear.add((int)Math.ceil((100 - progresses[i])/(double)speeds[i]));
        }

        int count;
        int compare;
        while(!clear.isEmpty()){
            compare = clear.poll();
            count=1;
            // 맨 앞의 일수보다 작은 것이 뒤에 있다면 계속 지우면서 count 증가
            while(!clear.isEmpty()&&compare>=clear.peek()){
                clear.poll();
                count++;
            }
            result.add(count);
        }
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}