import java.io.*;
import java.util.*;

public class Main {
    private static int TC = 0;
    private static int[] colors;
    private static List<Integer>[] graph;
    private static boolean isBinaryGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < TC; i++) {
            isBinaryGraph = true;
            String[] token = br.readLine().split(" ");
            int V = Integer.parseInt(token[0]);
            int E = Integer.parseInt(token[1]);
            colors = new int[V+1];
            graph = new ArrayList[V+1];
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            for(int j = 0 ; j < E ; j++) {
                token = br.readLine().split(" ");
                int x = Integer.parseInt(token[0]);
                int y = Integer.parseInt(token[1]);
                graph[x].add(y);
                graph[y].add(x);
            }

            for (int j = 1; j <= V; j++) {
                if (colors[j] == 0) {
                    dfs(j, 1);
                }
            }

            if(isBinaryGraph)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void dfs(int node, int color) {
        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (colors[neighbor] == 0) {
                dfs(neighbor, 3 - color);
            } else if (colors[neighbor] == color) {
                isBinaryGraph = false;
            }
        }
    }
}
