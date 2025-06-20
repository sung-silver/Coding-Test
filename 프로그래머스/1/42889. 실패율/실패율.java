import java.util.*;

class Solution {
    class Stage implements Comparable<Stage> {
        private int id;
        private double error;
        
        public Stage(int id, double error) {
            this.id = id;
            this.error = error;
        }
        
        @Override
        public int compareTo(Stage o) {
            if(error < o.error)
                return -1;
            if(error > o.error)
                return 1;
            return 0;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] errorCount = new int[N+2];
        int[] totalCount = new int[N+2];
        List<Stage> errorRates = new ArrayList<>();
        
        for(int i=0 ; i<stages.length ; i++) {
            if(stages[i] < N+1) {
                errorCount[stages[i]]++;
            }
        }
        
        int remain = stages.length;
        
        for (int i = 1; i <= N; i++) {
            double rate = remain == 0 ? 0.0
                              : (double) errorCount[i] / remain;
            errorRates.add(new Stage(i, rate));
            remain -= errorCount[i];
        }
        
        Collections.sort(errorRates, Collections.reverseOrder());
        
        for(int i=0; i<N; i++) {
            answer[i] = errorRates.get(i).id;
        }
        return answer;
    }
}