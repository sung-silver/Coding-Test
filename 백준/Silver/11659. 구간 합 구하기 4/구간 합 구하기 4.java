import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int round = Integer.parseInt(st.nextToken());
        long[] S = new long[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0 ; i<N ; i++) {
            if(i==0) {
                S[0] = Long.parseLong(st.nextToken());
            } else {
                S[i] = S[i-1] + Long.parseLong(st.nextToken());
            }
        }

        for(int j=0 ; j<round ; j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if(start == 0) {
                bw.write(S[end] + "\n");
            } else {
                bw.write(S[end]-S[start-1]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
