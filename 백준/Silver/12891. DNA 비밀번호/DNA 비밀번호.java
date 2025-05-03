import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();
        st = new StringTokenizer(br.readLine());
        int countA = Integer.parseInt(st.nextToken());
        int countC = Integer.parseInt(st.nextToken());
        int countG = Integer.parseInt(st.nextToken());
        int countT = Integer.parseInt(st.nextToken());
        int compareA = 0;
        int compareC = 0;
        int compareG = 0;
        int compareT = 0;
        int subDNAPasswordCount = 0;

        int start = 0;
        int end = P - 1;

        for (int i = start; i <= end; i++) {
            if (DNA.charAt(i) == 'A') compareA++;
            if (DNA.charAt(i) == 'C') compareC++;
            if (DNA.charAt(i) == 'G') compareG++;
            if (DNA.charAt(i) == 'T') compareT++;
        }

        while (true) {
            if (compareA >= countA && compareC >= countC && compareG >= countG && compareT >= countT) {
                subDNAPasswordCount++;
            }
            if (DNA.charAt(start) == 'A' && compareA > 0) compareA--;
            if (DNA.charAt(start) == 'C' && compareC > 0) compareC--;
            if (DNA.charAt(start) == 'G' && compareG > 0) compareG--;
            if (DNA.charAt(start) == 'T' && compareT > 0) compareT--;
            start++;
            end++;
            if(end > S-1) break;
            if (DNA.charAt(end) == 'A') compareA++;
            if (DNA.charAt(end) == 'C') compareC++;
            if (DNA.charAt(end) == 'G') compareG++;
            if (DNA.charAt(end) == 'T') compareT++;
        }

        bw.write(String.valueOf(subDNAPasswordCount));
        bw.flush();
        bw.close();
    }
}
