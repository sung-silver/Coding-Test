import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        int remain = 0;
        int count = 0;
        int header = 0;
        for (int i = 0; i < progresses.length; i++) {
            remain = 100 - progresses[i];
            if (remain % speeds[i] == 0) {
                queue.add(remain / speeds[i]);
            } else {
                queue.add(remain / speeds[i] + 1);
            }
        }

        while(!queue.isEmpty()){
            header = queue.poll();
            count++;
            while(!queue.isEmpty() && header >= queue.peek()){
                queue.poll();
                count++;
            }
            answerList.add(count);
            count = 0;
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}