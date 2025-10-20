import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        stars = new int[K][2];
        for(int i=0 ; i<K ; i++) {
            st =  new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i][0] = x;
            stars[i][1] = y;
        }

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int x1 = stars[i][0];
                int y1 = stars[j][1];
                int x2 = x1 + L;
                int y2 = y1 + L;

                int count = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[k][0] >= x1 && stars[k][0] <= x2 &&
                            stars[k][1] >= y1 && stars[k][1] <= y2) {
                        count++;
                    }
                }
                answer = Math.max(answer, count);
            }
        }

        System.out.println(K-answer);
    }
}
