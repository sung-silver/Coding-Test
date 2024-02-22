import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i : prices){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            int price = queue.poll();
            int count = 0;

            if(queue.isEmpty()){
                arrayList.add(0);
                break;
            }

            for(int i = arrayList.size();i<prices.length;i++){
                if(i == prices.length-1){
                    arrayList.add(count);
                    break;
                }
                if(price <= prices[i]){
                    count++;
                }
                else{
                    arrayList.add(count);
                    break;
                }
            }
        }

        answer = arrayList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}