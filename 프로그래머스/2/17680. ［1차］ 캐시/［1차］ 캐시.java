import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // LRU 알고리즘 가장 최근에 접근하지 않은 페이지를 교체
        int answer = 0;
        List<String> cache = new ArrayList<>();
        
        for(String city : cities) {
            String cityName = city.toLowerCase();
            
            if(cache.contains(cityName)) {
                answer++;
                cache.add(cityName);
                cache.remove(cityName);
            } else {
                if(cache.size() < cacheSize) {
                    cache.add(cityName);
                    answer += 5;
                } else {
                    cache.add(cityName);
                    cache.remove(0);
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}