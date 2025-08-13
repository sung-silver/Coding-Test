import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        int N = Integer.parseInt(inputs[0]);
        int L = Integer.parseInt(inputs[1]);

        for(int i = L ; i <= 100 ; i++) {
            long a = getStartNumber(i, N);
            if(a != -1) {
                for(int j=(int)a ; j<a+i ; j++) {
                    System.out.print(j+" ");
                }
                return ;
            }
        }

        System.out.println("-1");
    }

    private static long getStartNumber(int L, int N) {
        // t = N - L*(L-1)/2
        long t = (long) N - (long) L * (L - 1) / 2;
        if (t < 0) return -1;
        if (t % L != 0) return -1;   // a가 정수가 아니면 불가
        return t / L; // a
    }
}