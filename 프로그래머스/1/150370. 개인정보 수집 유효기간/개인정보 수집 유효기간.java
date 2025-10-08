import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, LocalDate> map = new HashMap<>();
        Map<String, Integer> term = new HashMap<>();
        LocalDate todays = LocalDate.parse(today, formatter);
        
        for(String t : terms) {
            String[] s = t.split(" ");
            term.put(s[0], Integer.valueOf(s[1]));
        }
        
        // 약관 종류에 따라 id, expireDate를 저장한다
        for(int i = 0 ; i < privacies.length ; i++) {
            String[] s = privacies[i].split(" ");
            int plusMonth = term.get(s[1]);
            LocalDate date = LocalDate.parse(s[0], formatter);
            date = date.plusMonths(plusMonth);
            map.put(i+1, date);
        }
        
        // 맵을 돌면서 expireDate를 비교하며 파기해야하는 정보의 id를 answer에 담는다
        for(Map.Entry<Integer, LocalDate> e : map.entrySet()) {
            if(checkExpire(todays, e.getValue())) {
                answer.add(e.getKey());
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    private boolean checkExpire(LocalDate today, LocalDate compare) {
        if(!compare.isAfter(today)) {
            return true;
        }
        
        return false;
    }
}