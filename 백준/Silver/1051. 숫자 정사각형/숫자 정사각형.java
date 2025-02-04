import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int S = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int k=0 ; k < Math.min(N - i, M - j); k++) {
                    int a = board[i][j];
                    int b = board[i+k][j];
                    int c = board[i][j+k];
                    int d = board[i+k][j+k];
                    if (a==b & b==c & c==d) {
                        S = Math.max(S, (k+1)*(k+1));
                    }
                }
            }
        }
        bw.write(String.valueOf(S));
        bw.flush();
        bw.close();
    }
}
