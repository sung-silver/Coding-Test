import java.io.*;
import java.util.*;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {
    private static int N;
    private static int M;
    private static boolean[] open;
    private static ArrayList<Point> chicken = new ArrayList<>();
    private static ArrayList<Point> house = new ArrayList<>();
    private static int minDistanceOfCity = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int number = Integer.parseInt(st.nextToken());
                Point point  = new Point(i, j);
                if(number == 1) {
                    house.add(point);
                }
                else if(number == 2) {
                    chicken.add(point);
                }
            }
        }
        open = new boolean[chicken.size()];
        minDistanceOfCity = Integer.MAX_VALUE;
        dfs(0, 0);

        bw.write(String.valueOf(minDistanceOfCity));
        bw.flush();
        bw.close();
    }

    private static void dfs(int start, int count) {
        if(count == M) {
            int sumOfDistance = 0;

            for (int i=0; i<house.size(); i++) {
                int minDistanceOfHouse = Integer.MAX_VALUE;
                for (int j=0; j< chicken.size(); j++) {
                    if(open[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        minDistanceOfHouse = Math.min(minDistanceOfHouse, distance);
                    }
                }
                sumOfDistance += minDistanceOfHouse;
            }
            minDistanceOfCity = Math.min(minDistanceOfCity, sumOfDistance);
            return;
        }

        for(int i=start; i< chicken.size();i++) {
            if(!open[i]) {
                open[i] = true;
                dfs(i+1, count+1);
                open[i] = false;
            }
        }
    }
}