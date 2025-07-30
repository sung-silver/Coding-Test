import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static final int FINISH = 100;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]); // 사다리
        int M = Integer.parseInt(parts[1]); // 뱀
        Map<Integer, Integer> teleport = new HashMap<>();
        visited = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            parts = br.readLine().split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            teleport.put(from, to);
        }

        bfs(1, teleport);
    }

    public static void bfs(int start, Map<Integer, Integer> teleport) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int index = current[0];
            int count = current[1];

            if (index == FINISH) {
                System.out.println(count);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = index + i;
                if (next > FINISH) {
                    continue;
                }
                next = teleport.getOrDefault(next, next);
                
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, count + 1});
                }
            }
        }
    }
}
