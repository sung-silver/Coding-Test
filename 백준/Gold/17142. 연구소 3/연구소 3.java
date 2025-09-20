import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] originalMap;
    static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static List<int[]> virusList;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 맵 크기 (NxN)
        M = Integer.parseInt(st.nextToken()); // 활성 바이러스 개수
        originalMap = new int[N][N];
        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
                if (originalMap[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
            }
        }

        makeVirus(0, 0, new ArrayList<>());

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // 바이러스 M개 선택 (조합)
    static void makeVirus(int idx, int count, List<int[]> path) {
        if (count == M) {
            answer = Math.min(answer, bfs(path));
            return;
        }
        if (idx >= virusList.size()) return;

        // 현재 바이러스 선택
        path.add(virusList.get(idx));
        makeVirus(idx+1, count+1, path);
        path.remove(path.size()-1);

        // 현재 바이러스 미선택
        makeVirus(idx+1, count, path);
    }

    // BFS로 퍼뜨리기
    static int bfs(List<int[]> activeVirus) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        int emptyCount = 0;   // 전체 빈 칸 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (originalMap[i][j] == 0) emptyCount++;
            }
        }
        if (emptyCount == 0) return 0; // 처음부터 다 채워져 있음

        for (int[] v : activeVirus) {
            q.offer(new int[]{v[0], v[1], 0}); // r, c, time
            visited[v[0]][v[1]] = true;
        }

        int maxTime = 0;
        int filledCount = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], t = cur[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (isValid(nr, nc) && !visited[nr][nc] && originalMap[nr][nc] != 1) {
                    visited[nr][nc] = true;
                    if (originalMap[nr][nc] == 0) {
                        filledCount++;
                        maxTime = t + 1;
                    }
                    q.offer(new int[]{nr, nc, t+1});
                }
            }
        }

        return (filledCount == emptyCount) ? maxTime : Integer.MAX_VALUE;
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
