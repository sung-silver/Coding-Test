import java.util.*;

class Solution {
    private boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire : wires) { // 양방향
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires) {
            visited = new boolean[n+1];
            int count = dfs(graph, wire[0], wire[1], 1);
            int diff = Math.abs((n - count) - count);
            answer = Math.min(answer, diff);
        }

        return answer;
    }
    
    int dfs(List<List<Integer>> graph, int dcv1, int dcv2, int node) {
        int count = 1;
        visited[node] = true;
        
        for(int con : graph.get(node)) {
            if((node == dcv1 && con == dcv2) || (node == dcv2 && con == dcv1)) {
                continue;
            }
            if(!visited[con]) {
                count += dfs(graph, dcv1, dcv2, con);
            }
        }
        
        return count;  
    }
}