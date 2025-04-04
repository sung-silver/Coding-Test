import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum = 0;
        String numbers = br.readLine();

        for(int i=0 ; i<N ; i++) {
            sum += numbers.charAt(i) - '0';
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
