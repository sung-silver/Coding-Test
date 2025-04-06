import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[N+1];
        long[] C = new long[M];
        long count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<N+1 ; i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
            int remainder = (int) (S[i] % M);
            C[remainder]++;
        }

        count = C[0];

        for(int j=0 ; j<M ; j++) {
            if(C[j] > 1) {
                count += C[j] * (C[j] - 1) / 2;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}