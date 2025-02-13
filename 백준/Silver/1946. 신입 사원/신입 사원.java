import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc > 0) {
            int N = scanner.nextInt();
            int selected = 0;
            int minInterviewRank = Integer.MAX_VALUE;

            List<int[]> candidates = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int paper = scanner.nextInt();
                int interview = scanner.nextInt();
                candidates.add(new int[]{paper, interview});
            }

            // Sort candidates based on paper rank
            candidates.sort(Comparator.comparingInt(o -> o[0]));

            // Select candidates based on interview rank
            for (int[] candidate : candidates) {
                int interviewRank = candidate[1];
                if (interviewRank < minInterviewRank) {
                    selected++;
                    minInterviewRank = interviewRank;
                }
            }

            System.out.println(selected);
            tc--;
        }
    }
}