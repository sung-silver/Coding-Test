import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 0;

        while(start<=end) {
            if(sum==N) {
                count++;
                end++;
                sum+=end;
            }
            else if (sum < N) {
                end++;
                sum += end;
            }
            else {
                sum-=start;
                start++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
