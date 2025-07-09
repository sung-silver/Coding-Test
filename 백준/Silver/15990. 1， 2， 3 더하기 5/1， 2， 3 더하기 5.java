import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String args[]) throws Exception {
        // 1,2,3을 가지고 합을 만들 수 있음 -> dp?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;


        // 4 = 1+3
        // = 3+1
        // 1+2+1
        // 1+3

        // 5
        // 1+3+1
        // 2+1+2
        // 3+2
        // 2+3

        // 6
        // 2+1+2+1
        // 3+2+1
        // 1+2+1+2
        // 3+1+2
        // 1+2+3
        // 2+1+3


        for(int i = 4 ; i < 100001 ; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009; // 뒤에가 1
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009; // 뒤에가 2
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009; // 뒤에가 3
        }

        for(int i = 0 ; i < tc ; i++) {
            int num = Integer.parseInt(br.readLine());
            long result = (dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009;
            bw.write(String.valueOf(result) + '\n');
        }
        bw.flush();
        bw.close();
    }
}
