class Solution {
    private int count = 0;
    public int solution(int[] numbers, int target) {
        count = 0;
        dfs(0, target, numbers, 0);
        return count;
    }
    
    
    void dfs(int idx, int target, int[] numbers, int result) {
        if(idx == numbers.length) {
            if(result == target) {
                count++;
            }
            return;
        }
        dfs(idx+1, target, numbers, result+numbers[idx]);
        dfs(idx+1, target, numbers, result-numbers[idx]);
    }
}