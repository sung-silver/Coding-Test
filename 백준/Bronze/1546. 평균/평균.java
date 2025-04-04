import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double maxScore = 0;
        double newSum = 0;
        double newAvg = 0;
        double[] scores = new double[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0 ; i<N ; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
            maxScore = Math.max(maxScore, scores[i]);
        }

        for(int j=0; j<N; j++) {
            double newScore = scores[j] /maxScore * 100;
            newSum += newScore;
        }

        newAvg = newSum / N;

        bw.write(String.valueOf(newAvg));
        bw.flush();
        bw.close();
    }
}
