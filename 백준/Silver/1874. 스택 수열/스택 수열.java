import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] permutation = new int[N];
        List<Character> op = new ArrayList<>();

        for(int i=0 ; i<N ; i++) {
            permutation[i] = Integer.parseInt(br.readLine());
        }

        int current = 0;
        int start = 1;
        stack.push(start);
        op.add('+');
        while(current < N && start <= N) {
            if(!stack.isEmpty() && stack.peek() == permutation[current]) {
                stack.pop();
                current++;
                op.add('-');
            } else {
                start++;
                stack.push(start);
                op.add('+');
            }
        }

        if(!stack.isEmpty()) {
            bw.write("NO");
        } else {
            for (Character character : op) {
                bw.write(character + "\n");
            }
        }


        bw.flush();
        bw.close();

    }
}
