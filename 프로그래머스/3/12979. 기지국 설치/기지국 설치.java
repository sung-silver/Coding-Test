class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int quotient = 0;
        int mod = 0;
        int div = 2 * w + 1;
        int length = 0;
        int start = 1;
        int end = stations[0] - w - 1;
        
        if(end >= 1 && start <= end) {
            length = end - start + 1;
            quotient = length / div;
            mod = length % div;
            if(mod != 0) {
                answer++;
            }
            answer += quotient;
        }
        
        for(int i=0 ; i<stations.length-1 ; i++) {
            start = stations[i] + w + 1;
            end = stations[i+1] - w -1;
            length = end - start + 1;
            if (length <= 0) continue; 
            quotient = length / div;
            mod = length % div;
            if(mod != 0) {
                answer++;
            }
            answer += quotient;
        }
        
        start = stations[stations.length-1] + w + 1;
        end = n;
        
        if(start <= n && start <= end) {
            length = end - start + 1;
            quotient = length / div;
            mod = length % div;
            if(mod != 0) {
                answer++;
            }
            answer += quotient;
        }
    

        return answer;
    }
}