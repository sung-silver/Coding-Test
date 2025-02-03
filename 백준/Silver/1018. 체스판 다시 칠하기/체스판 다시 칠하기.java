import java.io.*;
import java.util.*;

// 8*8 체스판을 만들 때

public class Main {
    static final char[] one = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
    final static char[] two = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int answer = 64;
        String line;
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        char[][] board = new char[M][N];
        for(int i = 0; i<M ; i++) {
            line = br.readLine();
            for(int j= 0; j<N ; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i<=M-8 ; i++) {
            for(int j= 0; j<=N-8 ; j++) {
                answer = Math.min(answer, getCount(board, i, j));
            }
        }

        System.out.println(answer);

    }

    public static int getCount(char[][] board, int x, int y) {
        int blackCount = 0;
        int width = 0;
        int height = 0;
        for(int i = x; i<x+8 ; i++) {
            for(int j= y; j<y+8 ; j++, width++) {
                if(height%2 ==0) {
                    if(one[width] != board[i][j]) {
                        blackCount++;
                    }
                } else {
                    if(two[width] != board[i][j]) {
                        blackCount++;
                    }
                }
            }
            height++;
            width = 0;
        }
        return Math.min(blackCount, 64-blackCount);
    }
}