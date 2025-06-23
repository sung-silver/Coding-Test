import java.util.*;

class Solution {
    class Vertex{
        private int id;
        private int length;
        
        Vertex(int id, int length) {
            this.id = id;
            this.length = length;
        }
        
        public int getId() {
            return id;
        }
        
        public int getLength() {
            return length;
        }
    }
    
    boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n+1];
        answer = bfs(edge);
        return answer;
    }
    
    public int bfs(int[][] edge) {
        Queue<Vertex> q = new LinkedList<>();
        ArrayList<Vertex> arr = new ArrayList<>();
        Vertex start = new Vertex(1, 0);
        q.add(start);
        arr.add(start);
        visited[1] = true;
        
        while (!q.isEmpty()) {
			Vertex current = q.poll();
            for (int[] ints : edge) {
                int id1 = ints[0];
                int id2 = ints[1];
                if (current.getId() == id1 && !visited[id2]) {
                    Vertex vertex = new Vertex(id2, current.getLength() + 1);
                    arr.removeIf(v -> v.getLength() < vertex.getLength());
                    visited[id2] = true;
                    arr.add(vertex);
                    q.add(vertex);
                }
				if (current.getId() == id2 && !visited[id1]) {
					Vertex vertex = new Vertex(id1, current.getLength() + 1);
					arr.removeIf(v -> v.getLength() < vertex.getLength());
					visited[id1] = true;
					arr.add(vertex);
					q.add(vertex);
				}
			}
		}
        return arr.size();
    }
}