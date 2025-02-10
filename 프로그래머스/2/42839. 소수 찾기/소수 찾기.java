import java.util.*;

class Solution {
    private Set<Integer> set;
    private char[] number;
    private boolean[] visited;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        number = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++) {
            number[i] = numbers.charAt(i);
        }
        
        for(int i=0; i<numbers.length(); i++) {
            visited[i] = true;
            permutation(String.valueOf(number[i]));
            visited[i] = false;
        }
        
        return set.size();
    }
    
    private void permutation(String str) {
        int num = Integer.parseInt(str);
        
        if(num > 1 && isPrime(num) ){
            set.add(num);
        }
        
        StringBuilder sb = new StringBuilder(str);
        
        for(int i=0 ; i<number.length;i++) {
            if(!visited[i]) {
                visited[i] = true; 
                permutation(str+number[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}