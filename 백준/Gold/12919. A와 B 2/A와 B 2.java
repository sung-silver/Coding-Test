import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean isSame = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        dfs(T, S);
        System.out.println(isSame ? 1 : 0);
    }

    private static void dfs(String t, String s) {
        if (t.length() == s.length()) {
            if (t.equals(s)) {
                isSame = true;
            }
            return;
        }

        // 끝이 A면 제거
        if (t.endsWith("A")) {
            dfs(t.substring(0, t.length() - 1), s);
        }

        // 시작이 B면 제거 후 reverse
        if (t.startsWith("B")) {
            StringBuilder sb = new StringBuilder(t.substring(1));
            dfs(sb.reverse().toString(), s);
        }
    }
}
