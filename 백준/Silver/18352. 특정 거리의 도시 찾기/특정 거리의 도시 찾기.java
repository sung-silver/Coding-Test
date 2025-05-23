import java.io.*;
import java.sql.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] graph;
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int initial = Integer.parseInt(st.nextToken());
        ArrayList<Integer> answer = new ArrayList<>();

        graph = new ArrayList[node+1];
        visited = new int[node+1];

        for(int i=1 ; i<node+1 ; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0 ; i<node+1 ; i++) {
            visited[i] = -1;
        }

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        bfs(initial);

        for(int i=1 ; i<node+1 ; i++) {
            if(visited[i] == distance) {
                answer.add(i);
            }
        }

        Collections.sort(answer);

        if(answer.isEmpty()) {
            bw.write(-1+"\n");
        } else {
            for(int i : answer) {
                bw.write(i+"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int linkedNode : graph[now]) {
                if(visited[linkedNode] == -1) {
                    visited[linkedNode] = visited[now] + 1;
                    queue.add(linkedNode);
                }
            }
        }
    }
}