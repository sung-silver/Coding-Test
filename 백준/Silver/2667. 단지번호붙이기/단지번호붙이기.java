import java.io.*;
import java.util.*;

public class Main {
    private static int N = 0;
    private static boolean[][] visited;
    private static int[][] village;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        village = new int[N][N];

        for(int i=0 ; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                village[i][j] = line.charAt(j) - '0';
            }
        }

        int villageCount = 0;
        ArrayList<Integer> eachHomeCount = new ArrayList<>();

        for(int i=0 ; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && village[i][j]==1) {
                    villageCount++;
                    count = 0;
                    dfs(i, j);
                    eachHomeCount.add(count);
                }
            }
        }

        System.out.println(villageCount);
        eachHomeCount.sort(Comparator.naturalOrder());
        eachHomeCount.forEach(System.out::println);
    }

    private static void dfs(int i, int j) {
        if(!visited[i][j] && village[i][j] == 1) {
            count++;
            visited[i][j] = true;
            if(j+1<N)
                dfs(i, j+1);
            if(j-1>=0)
                dfs(i, j-1);
            if(i-1>=0)
                dfs(i-1, j);
            if(i+1<N)
                dfs(i+1, j);
        }
    }
}