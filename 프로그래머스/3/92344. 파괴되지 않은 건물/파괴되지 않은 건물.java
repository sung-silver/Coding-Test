import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] delta = new int[n + 2][m + 2]; // [n+2][m+2]로 여유 있게

        // 변화량 기록
        for (int[] s : skill) {
            int type = s[0], r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4];
            int degree = (type == 1 ? -s[5] : s[5]);

            delta[r1][c1] += degree;
            delta[r1][c2 + 1] -= degree;
            delta[r2 + 1][c1] -= degree;
            delta[r2 + 1][c2 + 1] += degree;
        }

        // 가로 누적합
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                delta[i][j] += delta[i][j - 1];
            }
        }

        // 세로 누적합
        for (int j = 0; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                delta[i][j] += delta[i - 1][j];
            }
        }

        // 변화 적용 + 정답 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += delta[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}