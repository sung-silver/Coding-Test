import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Compare> numbers = new ArrayList<>();
        int max = 0;

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            numbers.add(new Compare(i, Integer.parseInt(st.nextToken())));
        }
        numbers.sort(Comparator.comparingInt(Compare::getValue));
        for(int i = 0; i < N ; i++) {
            int beforeIdx = numbers.get(i).getIdx();
            int afterIdx = i;
            max = Math.max(beforeIdx - afterIdx, max);
        }

        bw.write(String.valueOf(max+1));
        bw.flush();
        bw.close();
    }

    public static class Compare{
        private int idx;
        private int value;

        public Compare(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int getIdx() {
            return idx;
        }

        public int getValue() {
            return value;
        }
    }
}