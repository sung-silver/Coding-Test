class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        // 투포인터를 사용하여 시작지점~마지막지점의 합이 k와 같아지는 순간을 찾는다
        // k보다 작다면 end를 증가시키고 k보다 크다면 start를 증가시킨다
        int start = 0;
        int end = 0;
        int compare = sequence[0];
        int elementCount = Integer.MAX_VALUE;
        while(start<=end && end < sequence.length) {
            int currentElementCount = end - start + 1;
            if(compare == k) {
                if (currentElementCount < elementCount || (currentElementCount == elementCount && start < answer[0])) {
                    answer[0] = start;
                    answer[1] = end;
                    elementCount = currentElementCount;
                }
                compare -= sequence[start++];
            } else if(compare < k && end + 1 < sequence.length) {
                compare += sequence[++end];
            } else {
                compare -= sequence[start++];
            }
        }
        return answer;
    }
}