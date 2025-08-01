import java.util.*;

class Solution {
    public static int COMMAND = 0;
    public static int DIR = 1;

    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (String operation : operations) {
            String[] string = operation.split(" ");
            char command = string[COMMAND].charAt(COMMAND);
            int number = Integer.parseInt(string[DIR]);
            if(command == 'D' && minq.isEmpty()) {
                continue;
            }
            else if (command == 'I') {
                maxq.add(number);
                minq.add(number);
            } else if (command == 'D' && number == 1) {
                int max = maxq.poll();
                minq.remove(max);
            } else if (command == 'D' && number == -1) {
                int min = minq.poll();
                maxq.remove(min);
            }
        }
        
        if(minq.isEmpty()) {
            return answer;
        }
        
        answer[0] = maxq.poll();
        answer[1] = minq.poll();
        return answer;
    }
}