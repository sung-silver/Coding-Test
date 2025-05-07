import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String number = br.readLine();
        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = number.charAt(i) - '0';
        }

        for(int i=0; i<number.length(); i++) {
            int maxIdx = i;
            for(int j=i;j<number.length();j++) {
                if(digits[j] > digits[maxIdx]) maxIdx = j;
            }
            int temp = digits[i];
            digits[i] = digits[maxIdx];
            digits[maxIdx] = temp;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            result.append(digits[i]);
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}