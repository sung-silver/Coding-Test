import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int answer;
    static Set<String> visited;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        visited = new HashSet<>();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = -1;
            visited.clear();
            String[] line = sc.nextLine().split(" ");
            char[] values = line[0].toCharArray();
            int tryCount = Integer.parseInt(line[1]);
            dfs(values, tryCount);
            System.out.println("#"+test_case+" "+answer);
        }
    }

    static void dfs(char[] values, int tryCount) {
        if(tryCount==0) {
            int temp = Integer.parseInt(String.copyValueOf(values));
            answer = Math.max(temp, answer);
            return;
        }

        // 내 위치와 이후 위치의 값을을 교환하면서 값을 만든다
        // 같은 시도로 동일한 숫자를 만드는 경우에는 dfs를 시행하지 않는다
        // visited는 "문자열,시도횟수"로 판별한다

        for(int i=0; i<values.length ; i++) {
            for(int j=i+1; j<values.length ; j++) {
                swap(values, i, j);
                String tempKey = Arrays.toString(values) + "," + tryCount;
                if(!visited.contains(tempKey)) {
                    visited.add(tempKey);
                    dfs(values, tryCount-1);
                }
                swap(values, i, j);
            }
        }
    }

    static void swap(char[] values, int idx1, int idx2){
        char temp = values[idx1];
        values[idx1] = values[idx2];
        values[idx2] = temp;
    }
}