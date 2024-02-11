import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int counter = nums.length/2;
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for(int i : map.keySet()){
            if(map.get(i) > 0 && counter > 0){
                answer++;
                counter--;
            }
        }
        return answer;
    }
}