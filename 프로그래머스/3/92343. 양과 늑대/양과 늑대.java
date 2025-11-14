import java.util.*;

class Solution {
    int result;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        result = 0;
        List<List<Integer>> path = new ArrayList<>();
        
        for(int i = 0 ; i < info.length ; i++) {
            path.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            path.get(edge[0]).add(edge[1]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        
        dfs(0, 0, 0, candidates, path, info);
        
        answer = result;
        return answer;
    }
    
    void dfs(int node, int sheep, int wolf, List<Integer> candidates, List<List<Integer>> path, int[] info) {
        if(info[node]==0) sheep++;
        else wolf++;
        
        if(sheep <= wolf) return;
        
        result = Math.max(result, sheep);
        
        List<Integer> nextCandidates = new ArrayList<>(candidates);
        nextCandidates.remove(Integer.valueOf(node));
        nextCandidates.addAll(path.get(node));
        
        for(int next : nextCandidates) {
            dfs(next, sheep, wolf, nextCandidates, path, info);
        }
    }
}