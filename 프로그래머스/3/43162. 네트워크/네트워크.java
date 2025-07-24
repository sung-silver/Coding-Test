import java.util.*;

class Solution {
    // 방문 배열
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                bfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int current = q.poll();
            for(int i=0; i<n ; i++) {
                if(computers[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}