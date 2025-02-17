import java.io.*;
import java.util.*;

class Fibo {
    private int zero;
    private int one;

    public Fibo(int zero, int one) {
        this.zero = zero;
        this.one = one;
    }

    public int getZero() {
        return zero;
    }

    public int getOne() {
        return one;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Fibo[] fibos = new Fibo[41];
        fibos[0] = new Fibo(1, 0);
        fibos[1] = new Fibo(0, 1);

        for(int i=2; i<=40; i++) {
            int zero = fibos[i-2].getZero() + fibos[i-1].getZero();
            int one = fibos[i-2].getOne() + fibos[i-1].getOne();
            fibos[i] = new Fibo(zero, one);
        }

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            bw.write(fibos[number].getZero() + " " +fibos[number].getOne()+"\n");
        }

        bw.flush();
        bw.close();
    }
}
