import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        int M = 0;
        int sangPointer = 0;
        int sunPointer = 0;
        long count = 0;
        long[] sang;
        long[] sun;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
            sang = new long[N];
            sun = new long[M];
            sangPointer = 0;
            sunPointer = 0;
            count =0;
            for (int i = 0; i < N; i++) {
                sang[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                sun[i] = Integer.parseInt(br.readLine());
            }
            while (sangPointer < N && sunPointer < M) {
                if (sang[sangPointer] < sun[sunPointer]) {
                    sangPointer++;
                } else if (sang[sangPointer] > sun[sunPointer]) {
                    sunPointer++;
                } else {
                    sangPointer++;
                    sunPointer++;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
