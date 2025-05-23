import java.io.*;
import java.util.*;

public class Main {
    public static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int setCount = Integer.parseInt(st.nextToken());
        int operationCount = Integer.parseInt(st.nextToken());
        set = new int[setCount+1];

        for(int i=0 ; i< setCount+1 ; i++) {
            set[i] = i;
        }

        for(int i=0; i<operationCount ; i++){
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            if(operation == 0) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else if(operation == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int aSet = find(a);
                int bSet = find(b);
                if(aSet == bSet) {
                    bw.write("YES");
                }else {
                    bw.write("NO");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static int find(int x) {
        if(set[x] != x)
            set[x] = find(set[x]);
        return set[x];
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b) {
            set[b] = a;
        }
    }
}