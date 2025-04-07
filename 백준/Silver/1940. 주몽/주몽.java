import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        int count = 0;
        int start = 0;
        int end = N-1;
        int sum;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        sum = numbers[start] + numbers[end];
        while(start < end) {
            if(sum == M) {
                count++;
                sum -= numbers[start++];
                sum += numbers[start];
            }
            else if(sum < M) {
                sum -= numbers[start++];
                sum += numbers[start];
            } else {
                sum -= numbers[end--];
                sum += numbers[end];
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
