import java.io.*;
import java.util.*;

public class Main {
    private static int K = 0;
    private static int[] numbers;
    private static char[] sign;
    private static boolean[] visited;
    private static String max = "";
    private static String min = "9999999999";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[K+1];
        sign = new char[K];
        visited = new boolean[10];

        for(int i=0; i<K; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        for(int i=0 ; i<10 ; i++) {
            numbers[0] = i;
            visited[i] = true;
            dfs(i, 0);
            visited = new boolean[10];
        }



        bw.write(max+"\n");
        bw.write(min);
        bw.flush();
        bw.close();
    }

    private static void dfs(int i, int signIdx) {
        if(signIdx==K) {
            StringBuilder sb = new StringBuilder();
            for (int num : numbers) {
                sb.append(num);
            }
            String numStr = sb.toString();
            if (numStr.compareTo(max) > 0) {
                max = numStr;
            }
            if (numStr.compareTo(min) < 0) {
                min = numStr;
            }
            return;
        }

        for(int j=0 ; j<10 ; j++) {
            if(!visited[j] && checkStatement(i, j, signIdx)) {
                numbers[signIdx+1]= j;
                visited[j] = true;
                dfs(j, signIdx+1);
                visited[j] = false;
            }
        }
    }

    private static boolean checkStatement(int a, int b, int signIdx) {
        if(sign[signIdx] == '<') {
            return a<b;
        }
        return a>b;
    }
}
