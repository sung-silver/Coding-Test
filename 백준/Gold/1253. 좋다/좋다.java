import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] numbers = new long[N];
        int goodNumberCount = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(numbers);

        for(int i=0 ; i<numbers.length ; i++) {
            if(isGoodNumber(numbers[i], i, numbers))
                goodNumberCount++;
        }

        bw.write(String.valueOf(goodNumberCount));
        bw.flush();
        bw.close();
    }

    private static boolean isGoodNumber(long target, int targetIdx, long[] numbers) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (start == targetIdx) {
                start++;
                continue;
            }
            if (end == targetIdx) {
                end--;
                continue;
            }

            long sum = numbers[start] + numbers[end];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
