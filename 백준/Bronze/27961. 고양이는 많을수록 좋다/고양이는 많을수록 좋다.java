import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long count = getCount(N);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static long getCount(long N) {
        long count = 0;
        long cat = 0;

        if(N==0) {
            return 0L;
        }
        
        count++;
        cat++;

        while(cat != N) {
            if(cat == N - 1) { // 정답과 1 차이가 나면 한마리만 증가
                cat++;
            }
            else if(N / 2 < cat) { // 현재 고양이의 수가 N/2보다 크다면 복제 마법으로 한번에 해결 가능
                cat = N;
            }
            else { // 그 외에 N과의 차이를 줄이기 위해 2배씩 증가
                cat = cat*2;
            }
            count++;
        }
        return count;
    }
}
