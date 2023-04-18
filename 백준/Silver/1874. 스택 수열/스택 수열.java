import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = in.nextInt();
        int start = 0;
        
        while(N -- > 0) {
            int value = in.nextInt();

            if(start<value) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    result.append('+').append('\n');
                }
                start = value; 
            }
            else if(stack.peek() != value) { 
                System.out.println("NO");
                return;		
            }

            stack.pop();
            result.append('-').append('\n');
        }

        System.out.println(result);
    }
}