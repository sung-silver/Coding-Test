class Solution {
    int answer=0;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0,numbers,target);
        return answer;
    }
    
    void dfs(int n, int sum, int[] numbers, int target){
        if(n == numbers.length){ // 종료조건
            if(sum == target){ // 계산 결과가 타겟넘버와 같을 때 sum 증가
                answer++;
            }
            return ;
        }
        dfs(n+1, sum+numbers[n], numbers, target);
        dfs(n+1, sum-numbers[n], numbers, target);
    }
}