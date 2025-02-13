import java.io.*;
import java.util.*;

class Beer {
    int preference;
    int level;

    Beer(int preference, int level) {
        this.preference = preference;
        this.level = level;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Beer[] beers = new Beer[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int preference = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            beers[i] = new Beer(preference, level);
        }
        
        Arrays.sort(beers, Comparator.comparingInt(beer -> beer.level));

        PriorityQueue<Integer> preferenceQueue = new PriorityQueue<>();

        int currentPreferenceSum = 0;
        int minimumLevel = 0;

        for (Beer beer : beers) {
            preferenceQueue.offer(beer.preference);
            currentPreferenceSum += beer.preference;

            if (preferenceQueue.size() > N) {
                currentPreferenceSum -= preferenceQueue.poll();
            }

            if (preferenceQueue.size() == N && currentPreferenceSum >= M) {
                minimumLevel = beer.level;
                break;
            }
        }

        if (minimumLevel == 0) {
            bw.write("-1\n");
        } else {
            bw.write(minimumLevel + "\n");
        }

        bw.flush();
        bw.close();
    }
}