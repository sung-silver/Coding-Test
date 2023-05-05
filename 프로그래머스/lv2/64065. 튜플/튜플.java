import java.util.*;
class Solution {
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s,"},{"); // '}' , ',' , '{' 를 기준으로 토큰 분리

        // 숫자가 나온 횟수 세기
        HashMap<Integer, Integer> count = new HashMap<Integer,Integer>();
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            count.put(n,count.containsKey(n) ? count.get(n)+1 : 1);
            // count 내에 n을 key로하는 value가 저장되어 있다면 그 value + 1을 갱신하여 value로 저장하고 그렇지 않으면 1을 저장한다
        }

        // value(등장 횟수)를 기준으로 내림차순 정렬
        List<Integer> keySet = new ArrayList<Integer>(count.keySet()); // Map이 가진 Key들을 원소로 가진다
        Collections.sort(keySet, (v1,v2)->(count.get(v2)-count.get(v1)));
        
        int[] answer = new int[keySet.size()];
        for(int i=0;i<keySet.size();i++){
            answer[i] = keySet.get(i);
        }
        
        return answer;
    }
}