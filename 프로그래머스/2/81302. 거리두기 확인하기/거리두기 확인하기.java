import java.util.*;

class Solution {
    // 맨해튼 거리: |r1 - r2| + |c1 - c2|
    List<int []> person;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int[] solution(String[][] places) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0 ; i<places.length ; i++) {
            person = new ArrayList<>();
            checkPerson(places[i]);
            boolean isAvailable = true;
            for(int[] p : person) {
                isAvailable = isAvailable && bfs(p, places[i]);
            }
            if(isAvailable) answer.add(1);
            else answer.add(0);
        }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    // 사람의 위치를 미리 표시
    void checkPerson(String[] place) {
        for(int i=0 ; i<place.length ; i++) {
            for(int j=0 ; j<place[i].length() ; j++) {
                char c = place[i].charAt(j);
                if(c == 'P') {
                    person.add(new int[] {i, j});
                }
            }
        }
    }
    
    // BFS
    // List에 사용자 위치를 미리 넣어둠
    // bfs 시작 시 시작 node로 사용자 위치를 넣어둠
    // 파티션을 만난다면 더 진행하지 않음
    // 파티션이 아니라면 3번째의 거리를 맨해튼 거리로 증가하여 큐에 넣음
    // 현재 방문한 위치가 맨해튼 거리 3이상이라면 더 이상 탐색 X
    // 현재 방문한 위치가 맨해튼 거리 2이하인 경우 자리일경우 탐색 O
    // 현재 방문한 위치가 맨해튼 거리 2이하이면서 사람인 경우 false 반환
    boolean bfs(int[] person, String[] place) {
        Queue<int []> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new int[] {person[0], person[1], 0});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            boolean isFirstNode = now[0] == person[0] && now[1] == person[1];
             
            if(!isFirstNode && now[2] > 2) continue;
            
            if(!isFirstNode && now[2] <= 2 && place[now[0]].charAt(now[1]) == 'P') {
                return false;
            }
            
            for(int i=0 ; i<4 ; i++) {
                int nextR = now[0] + dir[i][0];
                int nextC = now[1] + dir[i][1];
                if(validate(nextR, nextC) && place[nextR].charAt(nextC) != 'X') { // 여기 거리를 시작 지점으로부터의 거리로 변환해야함
                    queue.add(new int[] {nextR, nextC, now[2]+1});
                }
            }
        }
        
        return true;
    }
    
    private boolean validate(int r, int c) {
        return r >=0 && r < 5 && c>=0 && c < 5;
    }
}