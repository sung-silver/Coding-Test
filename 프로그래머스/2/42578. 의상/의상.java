import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 1;

        for (String[] clothe : clothes) {
            if (map.containsKey(clothe[1])) {
                map.put(clothe[1], map.get(clothe[1]) + 1);
            } else {
                map.put(clothe[1], 1);
            }
        }

        for(String key : map.keySet()){
            result *= map.get(key)+1;
        }

        result--; // 전체를 선택하지 않는 경우
        return result;
    }
}