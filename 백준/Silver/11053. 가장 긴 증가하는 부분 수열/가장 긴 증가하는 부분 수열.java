import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int max = 1;
        int[] numbers = new int[N];
        int[] length = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++){
            length[i] = 1;
            for (int j = 0; j < i; j++){
                if(numbers[j] < numbers[i]){
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
            max = Math.max(length[i], max);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
