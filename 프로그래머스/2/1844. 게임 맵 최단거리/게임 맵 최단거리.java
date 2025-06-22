import java.util.*;

class Solution {
    boolean[][] visited;
    int[][] direction = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    
    class Node {
        private int x;
        private int y;
        private int distance;
        
        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public int getDistance() {
            return distance;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        answer = bfs(0,0,maps);
        return answer;
    }
    
    int bfs(int x, int y, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        Node start = new Node(x, y, 1);
        q.add(start);
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            for(int i=0 ; i<4 ; i++) {
                int nx = current.getX() + direction[i][0];
                int ny = current.getY() + direction[i][1];
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length || visited[nx][ny] == true || maps[nx][ny] == 0) {
                    continue;
                }
                if(nx == maps.length-1 && ny == maps[0].length-1) {
                    return current.getDistance() + 1;
                }
                Node node = new Node(nx, ny, current.getDistance()+1);
                q.add(node);
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}