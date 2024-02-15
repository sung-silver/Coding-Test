import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> playCount = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        // 장르별 총 노래 개수 구하기
        for (int i=0; i<genres.length;i++) {
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }

        // 장르별 노래(노래 고유번호, 재생횟수) 저장하기
        for (int i = 0; i < plays.length; i++) {
            if (!playCount.containsKey(genres[i])) {
                playCount.put(genres[i], new HashMap<>());
            }
            playCount.get(genres[i]).put(i, plays[i]);
        }

        while(!map.isEmpty()){
            String genre = "";
            int max = 0;

            for(String key : map.keySet()){
                if(map.get(key)>max){
                    max = map.get(key);
                    genre = key;
                }
            }
            List<Integer> keySetList = new ArrayList<>(playCount.get(genre).keySet());
            String compare = genre;
            Collections.sort(keySetList, (o1, o2) -> (playCount.get(compare).get(o2).compareTo(playCount.get(compare).get(o1))));

            for (int i = 0; i < 2 && i < keySetList.size(); i++) {
                answerList.add(keySetList.get(i));
            }
            map.remove(genre);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}