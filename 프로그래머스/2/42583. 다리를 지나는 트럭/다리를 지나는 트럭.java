import java.util.*;

class Solution {
    // hint 다리를 큐라고 생각하자!
    // 다리 위에는 최대 다리 길이 만큼의 트럭이 올라갈 수 있다 (다리가 견딜 수 있는 하중을 고려하지 않는다면)
    // 다리 위의 트럭들의 무게의 합은 weight보다 같거나 작아야 한다
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int now_bridge_weight = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i< truck_weights.length;i++) {
            int truck = truck_weights[i];
            while (true) {
                // 큐에 아무것도 없는 경우 = 다리 위에 트럭이 없는 경우
                if (queue.isEmpty()) {
                    queue.add(truck);
                    now_bridge_weight += truck;
                    answer++;
                    break; // 새로운 트럭을 더 올릴 수 있는지 확인하기 위해 무한 루프 종료
                } else if (queue.size() == bridge_length) { // 다리 위에 트럭이 가득 찰 경우(다리가 견딜 수 있는 무게가 엄청 크면 가능)
                    now_bridge_weight -= queue.poll();
                } else {
                    if (now_bridge_weight + truck <= weight) { // 다리가 견딜 수 있는 무게를 넘지 않으면, 계속 큐(댜리)에 추가
                        queue.add(truck);
                        now_bridge_weight += truck;
                        answer++;
                        break; // 새로운 트럭을 더 올릴 수 있는지 확인하기 위해 무한 루프 종료
                    } else { // 디리가 견딜 수 없는 무게라면 0을 추가하여 큐(다리)에 있는 맨 앞의 트럭을 지나가게 만듦
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer+bridge_length; // 마지막 트럭이 다리를 다 건너는 시간은 고려할 수 없으므로 더해준다
    }
}