import java.util.*;
class Solution {
    public class Pair{
        private int location;
        private int priority;
        public Pair(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

        public int getLocation(){
            return location;
        }

        public int getPriority(){
            return priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> priorityList = new ArrayList<>();
        for(int i=0;i<priorities.length;i++){
            Pair pair = new Pair(i, priorities[i]);
            queue.add(pair);
            priorityList.add(priorities[i]);
        }

        priorityList.sort(Collections.reverseOrder());

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.getPriority() == priorityList.get(0)) {
                answer++;
                priorityList.remove(0);
                System.out.println(pair.location);
                if (pair.getLocation() == location) {
                    return answer;
                }
            } else{
                queue.add(pair);
            }
        }

        return answer;
    }
}