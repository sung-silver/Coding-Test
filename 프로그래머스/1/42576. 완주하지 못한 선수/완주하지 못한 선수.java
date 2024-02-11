import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        for (String i : participant) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for(String i : completion){
            if(map.get(i)>0){
                map.put(i, map.get(i)-1);
            }
        }

        for(String j : map.keySet()){
            if(map.get(j)>0){
                return j;
            }
        }
        
        return answer;
    }
}