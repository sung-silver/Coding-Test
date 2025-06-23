import java.util.*;

class Solution {
    boolean[] visited;
    
    class Node {
        private int node;
        private int dest;
        
        Node(int node, int dest) {
            this.node = node;
            this.dest = dest;
        }
        
        public int getNode() {
            return node;
        }
        
        public int getDest() {
            return dest;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] e : roads) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        for(int i=0; i<sources.length ; i++) {
            visited = new boolean[n+1];
            answer[i] = bfs(sources[i], destination, graph);
        }
        
        
        return answer;
    }
    
    public int bfs(int start, int destination, List<Integer>[] graph) {
        Node first = new Node(start, 0);
        Queue<Node> q = new LinkedList<>();
        visited[start] = true;
        q.add(first);
        
        if(first.getNode() == destination) {
            return 0;
        }
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            for(int connect : graph[current.getNode()]) {
                if(!visited[connect]) {
                    Node node = new Node(connect, current.getDest()+1);
                    q.add(node);
                    visited[connect] = true;
                    if(node.getNode() == destination) {
                        return node.getDest();
                    }
                }
            }
        }
        
        return -1;  
    }
}