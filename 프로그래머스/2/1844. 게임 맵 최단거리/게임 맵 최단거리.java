import java.util.*;

class Solution {
    int[][] move = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        return bfs(0, 0, n, m, visited, maps);
    }
    
    public int bfs(int startX, int startY, int n, int m, boolean[][] visited, int[][] maps) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 1});
        visited[0][0] = true; // 첫번째 방문노드 초기화
        
        while(!q.isEmpty()){
            int[] compare = q.poll();
            int x = compare[0];
            int y = compare[1];
            int count = compare[2];
            
            boolean isTarget = x == n-1 && y == m-1;
            if(isTarget) {
                answer = count;
                break;
            }
            
            for(int i=0; i<4 ; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                
                boolean outOfBoard = nx < 0 || nx >= n || ny < 0 || ny >= m;
                if(outOfBoard) continue;
                boolean isBlocked = maps[nx][ny] == 0;
                if(isBlocked) continue;
                
                boolean isNotVisted = !visited[nx][ny];
                boolean isNotBlocked = maps[nx][ny] == 1;
                if(isNotVisted && isNotBlocked) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count+1});
                }
            }
        }
        return answer;
    }
}