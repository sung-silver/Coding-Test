import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> count = new HashMap<String,Integer>();
        
        // 의상 종류에 따른 의상 개수 구하기
        for(int i=0;i<clothes.length;i++){
            count.put(clothes[i][1],count.containsKey(clothes[i][1]) ? count.get(clothes[i][1])+1 : 1);
        }
        
        // 의상 종류별 의상 개수 + (안입는 경우)를 각각 구해 곱한다
        for(Map.Entry<String, Integer> e : count.entrySet()){
            answer *= e.getValue()+1;
        }
        
        answer--; // 모두 안입는 경우를 제외
        
        return answer;
    }
}