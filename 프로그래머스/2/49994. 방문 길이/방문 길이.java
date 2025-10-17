import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited = new boolean[11][11][11][11]; // {x, y, x1, y1}
        HashMap<Character, Delta> commands = new HashMap();
        commands.put('U', new Delta(0, 1));
        commands.put('D', new Delta(0, -1));
        commands.put('R', new Delta(1, 0));
        commands.put('L', new Delta(-1, 0));
        
        int currentX = 0;
        int currentY = 0;
        for(int i = 0 ; i < dirs.length() ; i++) {
            char c = dirs.charAt(i);
            Delta d = commands.get(c);

            int nextX = currentX + d.x;
            int nextY = currentY + d.y;
            
            if(nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }
            
            int cx = currentX + 5;
            int cy = currentY + 5;
            int nx = nextX + 5;
            int ny = nextY + 5;
            
            if(!visited[cx][cy][nx][ny]) {
                visited[cx][cy][nx][ny] = true;
                visited[nx][ny][cx][cy] = true;
                answer++;
            }
            
            currentX = nextX;
            currentY = nextY;
        }
        return answer;
    }
    
    class Delta {
        int x;
        int y;
        
        public Delta(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}