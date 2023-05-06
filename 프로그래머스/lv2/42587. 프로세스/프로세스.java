import java.util.*;
class Solution {
    public static class Pair{
        private int key;
        private int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Pair pair;
        Queue<Pair> queue = new LinkedList<>();
        List<Integer> desc = new ArrayList<Integer>();
        for(int i=0;i<priorities.length;i++){
            pair = new Pair(i,priorities[i]);
            queue.add(pair);
            desc.add(priorities[i]);
        }
        Collections.sort(desc,Collections.reverseOrder());

        for(int j=0; j<desc.size();) {
            if (desc.get(j) == queue.peek().value) {
                answer++;
                if ( queue.poll().key== location) {
                    break;
                }
                j++;
            } else {
                queue.add(queue.poll());
            }
        }
        return answer;
    }
}