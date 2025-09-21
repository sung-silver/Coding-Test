import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] originalMap;
    static boolean[][][][] visited; // [redR][redC][blueR][blueC]
    static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int redR = 0;
        int redC = 0;
        int blueR = 0;
        int blueC = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originalMap = new char[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                originalMap[i][j] = line.charAt(j);
                if(originalMap[i][j] == 'R'){
                    redR = i;
                    redC = j;
                } else if(originalMap[i][j] == 'B'){
                    blueR = i;
                    blueC = j;
                }
            }
        }

        System.out.println(bfs(redR, redC, blueR, blueC) ? 1 : 0);
    }

    // BFS로 퍼뜨리기
    static boolean bfs(int redR, int redC, int blueR, int blueC) {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][M][N][M];

        q.offer(new int[]{redR, redC, blueR, blueC, 0});
        visited[redR][redC][blueR][blueC] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curRedR = cur[0], curRedC = cur[1];
            int curBlueR = cur[2], curBlueC = cur[3];
            int t = cur[4];

            if(t >= 10) {
                continue;
            }


            for (int i = 0; i < 4; i++) {
                int dr = dir[i][0];
                int dc = dir[i][1];

                int[] redMove = move(curRedR, curRedC, dr, dc);
                int[] blueMove = move(curBlueR, curBlueC, dr, dc);

                int nRedR = redMove[0], nRedC = redMove[1], nRedCount = redMove[2];
                int nBlueR = blueMove[0], nBlueC = blueMove[1], nBlueCount = blueMove[2];

                if(originalMap[nBlueR][nBlueC] == 'O'){
                    continue;
                }

                if(originalMap[nRedR][nRedC] == 'O'){
                    return true;
                }

                // 두 구슬의 위치가 겹친다면 더 많이 이동한 구슬을 한칸 복구하기
                if(nRedR == nBlueR && nRedC == nBlueC){
                    if(nRedCount > nBlueCount){
                        nRedR -= dr;
                        nRedC -= dc;
                    } else {
                        nBlueR -= dr;
                        nBlueC -= dc;
                    }
                }

                if(!visited[nRedR][nRedC][nBlueR][nBlueC]){
                    visited[nRedR][nRedC][nBlueR][nBlueC] = true;
                    q.offer(new int[]{nRedR, nRedC, nBlueR, nBlueC, t+1});
                }
            }
        }

        return false;
    }


    // 벽이 닿을 때까지 움직이기
    static int[] move(int r, int c, int dr, int dc) {
        int count = 0;
        while(originalMap[r+dr][c+dc] != '#'&& originalMap[r][c] != 'O'){
            count++;
            r += dr;
            c += dc;
            if(originalMap[r][c] == 'O'){
                break;
            }
        }
        return new int[]{r, c, count};
    }
}
