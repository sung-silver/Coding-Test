import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static final int FINISH = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]); // 사다리
        int M = Integer.parseInt(parts[1]); // 뱀

        Map<Integer, Integer> teleport = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            parts = br.readLine().split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            teleport.put(from, to);
        }

        boolean[] visited = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();// [현재 위치, 이동 횟수]
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int count = current[1];

            if (position == FINISH) {
                System.out.println(count);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = position + dice;
                if (next > FINISH) continue;

                if (teleport.containsKey(next)) {
                    next = teleport.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, count + 1});
                }
            }
        }
    }
}