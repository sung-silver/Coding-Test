import java.util.*;

class Solution {
    // 방문여부 확인
    boolean[][] visited;
    char[][] map;
    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    class Node {
        private int x;
        private int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        List<Integer> sums = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        // maps를 char 배열로 변경해야함
        for(int i=0 ; i<maps.length ; i++) {
            for(int j=0; j<maps[0].length() ; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        // for문 돌면서 방문하지 않았고, X가 아닌 경우에 시작
        for(int i=0 ; i<map.length ; i++) {
            for(int j=0; j<map[0].length ; j++) {
                char current = map[i][j];
                if(!visited[i][j] && current != 'X') {
                    int sum = bfs(i, j);
                    sums.add(sum);
                }
            }
        }
        
        if (sums.isEmpty()) {
            answer = new int[] { -1 };
        }
        else {
            answer = sums.stream()
                 .mapToInt(Integer::intValue)
                 .toArray();
        }
        
        Arrays.sort(answer);
    
        return answer;
    }
    
    public int bfs(int x, int y) {
        int sum = 0;
        Queue<Node> queue = new LinkedList<>(); 
        Node start = new Node(x, y);
        queue.add(start);
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            sum += map[current.getX()][current.getY()] - '0';
            for(int i=0 ; i<4 ; i++) {
                int dx = current.getX() + directions[i][0];
                int dy = current.getY() + directions[i][1];
                if(dx < 0 || dx >= map.length || dy <0 || dy >= map[0].length) {
                    continue;
                }
                if(!visited[dx][dy] && map[dx][dy] != 'X') {
                    Node node = new Node(dx, dy);
                    queue.add(node);
                    visited[dx][dy] = true;
                }
            }
        }

        return sum;
    }
}