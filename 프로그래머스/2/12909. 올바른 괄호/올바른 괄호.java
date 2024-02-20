import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }
            else{
                if(stack.isEmpty()||stack.peek()!='('){
                    answer = false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}