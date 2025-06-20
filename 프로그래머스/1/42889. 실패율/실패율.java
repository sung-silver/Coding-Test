import java.util.*;

class Solution {

    public int[] solution(int N, int[] stages) {
        int[] failed  = new int[N + 2];
        int[] reached = new int[N + 2];

        for (int s : stages) {
            if (s <= N) failed[s]++;
            reached[s]++;
        }

        for (int i = N; i >= 1; i--) {
            reached[i] += reached[i + 1];
        }

        Integer[] order = new Integer[N];
        for (int i = 1; i <= N; i++) {
            order[i - 1] = i;
        }

        Arrays.sort(order, (a, b) -> {
            double rateA = reached[a] == 0 ? 0 : (double) failed[a] / reached[a];
            double rateB = reached[b] == 0 ? 0 : (double) failed[b] / reached[b];
            if (rateA == rateB) return a - b;
            return Double.compare(rateB, rateA);
        });

        return Arrays.stream(order).mapToInt(Integer::intValue).toArray();
    }
}
