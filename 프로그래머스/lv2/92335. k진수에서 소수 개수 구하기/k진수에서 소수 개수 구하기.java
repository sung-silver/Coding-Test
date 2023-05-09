import java.lang.Math;
class Solution {
    
    public boolean isPrime(double number){
        // 0과 1은 소수가 아니다
        if(number<2){
            return false;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            // 소수가 아닐 경우
            if(number % i ==0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n,k); // 변환할 수, k진법
        String[] primes = s.split("0");
        for(String prime : primes){
            if(prime.equals("")) continue;
            if(isPrime(Double.parseDouble(prime))){
                answer++;
            }
        }
        return answer;
    }
}