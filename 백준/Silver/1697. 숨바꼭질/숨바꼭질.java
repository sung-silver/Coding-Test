import java.io.*;
import java.util.*;

public class Main {
    private static int N = 0;
    private static int K = 0;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);
        K = Integer.parseInt(token[1]);
        visited = new boolean[100001];
        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] num = {-1, 1, 2};
        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0 ; i<size ; i++) {
                int idx = queue.poll();
                if(idx == K) {
                    return count;
                }

                for(int j=0; j<3 ; j++) {
                    int nextIdx;
                    if(j < 2) {
                        nextIdx = idx + num[j];
                    }
                    else {
                        nextIdx = idx * num[j];
                    }
                    if(nextIdx <0 || nextIdx > 100000 || visited[nextIdx]) {
                        continue;
                    }
                    queue.add(nextIdx);
                    visited[nextIdx] = true;
                }
            }
            count++;
        }
        return count;
    }
}