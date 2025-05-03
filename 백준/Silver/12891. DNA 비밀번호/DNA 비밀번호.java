import java.io.*;
import java.util.*;

public class Main {
    static int countA, countC, countG, countT;
    static int compareA, compareC, compareG, compareT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();
        st = new StringTokenizer(br.readLine());
        countA = Integer.parseInt(st.nextToken());
        countC = Integer.parseInt(st.nextToken());
        countG = Integer.parseInt(st.nextToken());
        countT = Integer.parseInt(st.nextToken());
        int subDNAPasswordCount = 0;
        
        for (int i = 0; i < P; i++) {
            add(DNA.charAt(i));
        }
        if (isValid()) subDNAPasswordCount++;
        for (int i = P; i < S; i++) {
            add(DNA.charAt(i));
            remove(DNA.charAt(i - P));
            if (isValid()) subDNAPasswordCount++;
        }
        bw.write(String.valueOf(subDNAPasswordCount));
        bw.flush();
        bw.close();
    }

    private static void add(char c) {
        switch (c) {
            case 'A': compareA++; break;
            case 'C': compareC++; break;
            case 'G': compareG++; break;
            case 'T': compareT++; break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A': compareA--; break;
            case 'C': compareC--; break;
            case 'G': compareG--; break;
            case 'T': compareT--; break;
        }
    }

    private static boolean isValid() {
        return compareA >= countA &&
                compareC >= countC &&
                compareG >= countG &&
                compareT >= countT;
    }
}