import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        int time = 0;
        int idx = 0;
        int count = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<Job> pq = new PriorityQueue<>();

        while (count < n) {
            while (idx < n && jobs[idx][0] <= time) {
                pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                Job now = pq.poll();
                time += now.taken; 
                answer += (time - now.request);
                count++;
            }
        }

        return answer / n;
    }

    class Job implements Comparable<Job> {
        int request;
        int taken;

        Job(int request, int taken) {
            this.request = request;
            this.taken = taken;
        }

        @Override
        public int compareTo(Job j) {
            return this.taken - j.taken;
        }
    }
}