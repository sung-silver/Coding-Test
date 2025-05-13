import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        int sum = 0;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while(pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += (a+b);
            pq.add(a+b);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}