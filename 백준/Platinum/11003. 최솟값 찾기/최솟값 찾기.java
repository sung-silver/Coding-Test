import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> nodes = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++) {
            int now = Integer.parseInt(st.nextToken());
            while(!nodes.isEmpty() && nodes.getLast().getValue() > now) {
                nodes.removeLast();
            }
            nodes.addLast(new Node(i, now));
            if(nodes.getFirst().getIdx() < i-L+1) {
                nodes.removeFirst();
            }
            bw.write(nodes.getFirst().getValue() + " ");
        }

        bw.flush();
        bw.close();
    }

    static public class Node {
        private final int idx;
        private final int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int getIdx() {
            return idx;
        }

        public int getValue() {
            return value;
        }
    }
}