import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int current = 0;
        
        for(int truck : truck_weights) {
            while(true) {
                if(q.isEmpty()) {
                    q.add(truck);
                    current += truck;
                    answer++;
                    break;
                }
                if(q.size() == bridge_length) {
                    current -= q.poll();
                } else {
                    if(current + truck <= weight) {
                        q.add(truck);
                        current += truck;
                        answer++;
                        break;
                    }
                    else {
                        q.add(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}