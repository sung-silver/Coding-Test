class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int width = triangle[height-1].length;
        int[][] dp = new int[height][width];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1 ; i<height ; i++) {
            for(int j=0 ; j<triangle[i].length ; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][0] + triangle[i][0];
                } else {
                    int right = dp[i-1][j] + triangle[i][j];
                    int cross = dp[i-1][j-1] + triangle[i][j];
                    dp[i][j] = Math.max(right, cross);
                }
            }
        }
        
        for(int i=0 ; i<width ; i++) {
            answer = Math.max(answer, dp[height-1][i]);
            
        }
        
        return answer;
    }
}