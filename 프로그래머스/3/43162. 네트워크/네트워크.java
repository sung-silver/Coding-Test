class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    void dfs(int target, int[][] computers) {
        for(int i = 0; i < computers.length ; i++) {
            if(!visited[i] && computers[target][i] == 1) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
}