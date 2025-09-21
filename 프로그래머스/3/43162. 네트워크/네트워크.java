import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<List<Integer>> graph;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        graph = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++) {
            List<Integer> arr = new ArrayList<>();
            for(int j=0 ; j<n ; j++) {
                if(computers[i][j] == 1) {
                    arr.add(j);
                }
            }
            graph.add(arr);
        }
        
        for(int i=0 ; i<n ; i++) {
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int now) {
        visited[now] = true;
        
        for(int next : graph.get(now)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}