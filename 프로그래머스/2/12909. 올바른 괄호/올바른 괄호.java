import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0 ; i<s.length() ; i++) {
            char current = s.charAt(i);
            if(current == '(') {
                stack.push('(');
            }
            if(current == ')' && stack.isEmpty()) {
                answer = false;
                break;
            }
            if(current == ')') {
                boolean correct = stack.peek() == '(';
                if(correct){
                    stack.pop();
                    answer = true;
                } else {
                    answer = false;
                    break;
                }
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}