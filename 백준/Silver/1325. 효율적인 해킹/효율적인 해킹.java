import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static List<Integer>[] graph;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[] computers;

        graph = new ArrayList[N + 1];
        computers = new int[N + 1];
        visited = new boolean[N + 1];
        for (int j = 1; j <= N; j++) {
            graph[j] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            graph[B].add(A);
        }

        for (int i = 1; i <= N; i++) {
            dfs(i);
            computers[i] = count;
            count = 0;
            visited = new boolean[N + 1];
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            if (max < computers[i]) {
                max = computers[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (computers[i] == max) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        for (int neighbor : graph[idx]) {
            if (!visited[neighbor]) {
                count++;
                dfs(neighbor); // 연결된 모든 노드를 탐색하며 count 증가
            }
        }
    }
}
