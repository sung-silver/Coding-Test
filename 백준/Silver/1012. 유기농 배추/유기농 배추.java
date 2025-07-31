import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] parts;
        int M; // 가로
        int N; // 세로
        int K; // 배추흰지렁이
        int x;
        int y;
        int count;

        for (int i=0 ; i<T ; i++) {
            parts = br.readLine().split(" ");
            M = Integer.parseInt(parts[0]);
            N = Integer.parseInt(parts[1]);
            K = Integer.parseInt(parts[2]);
            visited = new boolean[N][M];
            count = 0;

            int[][] board = new int[N][M];
            for (int j=0 ; j<K ; j++) {
                parts = br.readLine().split(" ");
                y = Integer.parseInt(parts[0]);
                x = Integer.parseInt(parts[1]);
                board[x][y] = 1;
            }


            for(int j=0; j<N ; j++) {
                for(int k=0 ; k<M ; k++) {
                    if(!visited[j][k] && board[j][k] == 1) {
                        dfs(j, k, board);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    public static void dfs(int x, int y, int[][] board) {
        visited[x][y] = true;

        for(int i=0 ; i<4 ; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) {
                if (!visited[nextX][nextY] && board[nextX][nextY] == 1) {
                    dfs(nextX, nextY, board);
                }
            }
        }

    }
}
