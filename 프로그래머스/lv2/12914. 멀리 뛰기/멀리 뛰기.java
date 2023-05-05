class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n+1];
        // n이 1인 경우
        if(n==1){
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2])%1234567; 
            // dp[i-1]의 경우의 수에 +1을 한 것과 dp[i-2]의 경우의 수에 +2를 한 것을 합치면 dp[i]의 경우의수를 알 수 있기 때문이다
        }
        answer = dp[n];
        return answer;
    }
}