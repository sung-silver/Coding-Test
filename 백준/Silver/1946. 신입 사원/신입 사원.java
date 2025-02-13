import java.io.*;
import java.util.*;

class Assignment {
    public int paper;
    public int interview;

    public Assignment(int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }
}


public class Main {
    private static int T;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        while(T>0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Assignment[] assignments = new Assignment[N];
            int answer = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                assignments[i] = new Assignment(paper, interview);
            }

            Arrays.sort(assignments, Comparator.comparingInt(o -> o.paper));
            int minInterviewRank = assignments[0].interview;
            answer++;

            for(int i=1 ; i<N; i++) {
                if(minInterviewRank > assignments[i].interview) {
                    minInterviewRank = assignments[i].interview;
                    answer++;
                }
            }

            bw.write(answer+"\n");
            T--;
        }

        bw.flush();
        bw.close();
    }
}