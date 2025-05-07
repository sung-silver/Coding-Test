import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N ; i++) {
            for(int j=i+1; j<N; j++) {
                if(numbers[j]<numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for(int i = 0 ; i < N ; i++) {
            bw.write(numbers[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}