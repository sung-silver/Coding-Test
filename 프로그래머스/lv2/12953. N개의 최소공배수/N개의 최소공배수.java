class Solution {
    // 최대 공약수 구하기 (유클리드 호제법)
    public int gcd(int p, int q){
        if(q==0) return p;
        return gcd(q, p%q);
    }
    
    public int solution(int[] arr) {
        int answer = 0;
        int gcdResult = gcd(arr[0],arr[1]);
        
        // 최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것과 같다
        answer = (arr[0]*arr[1])/gcdResult;
        
        // 입력 받는 숫자가 3개 이상일 경우에 위의 과정을 반복한다
        if(arr.length>2){
            for(int i=2;i<arr.length;i++){
                gcdResult = gcd(answer, arr[i]);
                answer = (answer*arr[i])/gcdResult;
            }
        }
        
        return answer;
    }
}