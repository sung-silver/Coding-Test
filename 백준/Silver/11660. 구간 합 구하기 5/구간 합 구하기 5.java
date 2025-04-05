import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int round = Integer.parseInt(st.nextToken());
        long[][] S = new long[N+1][N+1];

        for(int i=1 ; i<N+1 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<N+1; j++) {
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int j=0 ; j<round ; j++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            bw.write(S[x2][y2]-S[x1-1][y2]-S[x2][y1-1]+S[x1-1][y1-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
