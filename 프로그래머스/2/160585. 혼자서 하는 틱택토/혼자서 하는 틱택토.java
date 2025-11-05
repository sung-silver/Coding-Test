class Solution {
    
    public int solution(String[] board) {
        // 틱택토에서 나올 수 없는 상황
        // (1) X의 개수가 O의 개수보다 많음
        // (1.1) O가 승리하는 경우 O = X+1
        // (1.2) X가 승리하는 경우 O = X
        // (2) 이미 가세대(가로세로대각선)을 이루는 칸이 3개가 존재하는데 이런 경우가 반복됨
        // 8줄만 확인하면 됨
        
        int countO = 0;
        int countX = 0;
        boolean isWinO = false;
        boolean isWinX = false;
        
        for(int i=0 ; i<3 ; i++) {
            for(int j = 0 ; j<3 ; j++) {
                char c = board[i].charAt(j);
                if(c == 'O') countO++;
                else if(c == 'X') countX++;
            }
        }
        
        if(countX > countO || countO > countX + 1) {
            return 0;
        }
        
        isWinO = checkWin('O', board);
        isWinX = checkWin('X', board);
        
        // 둘 다 이기면 안됨
        if(isWinO && isWinX) return 0;
        
        // O가 이길 경우 X보다 말이 1개 더 많아야 함
        if(isWinO && countO != countX + 1) return 0;
        
        // X가 이길 경우 O와 말의 개수가 같아야 함
        if(isWinX && countX != countO) return 0;
        
        return 1;
    }
    
    boolean checkWin(char c, String[] board) {
        // 가로 3줄 검증
        if(board[0].charAt(0) == c && board[0].charAt(1) == c && board[0].charAt(2) == c) return true;
        if(board[1].charAt(0) == c && board[1].charAt(1) == c && board[1].charAt(2) == c) return true;
        if(board[2].charAt(0) == c && board[2].charAt(1) == c && board[2].charAt(2) == c) return true;
        
        // 세로 3줄 검증
        if(board[0].charAt(0) == c && board[1].charAt(0) == c && board[2].charAt(0) == c) return true;
        if(board[0].charAt(1) == c && board[1].charAt(1) == c && board[2].charAt(1) == c) return true;
        if(board[0].charAt(2) == c && board[1].charAt(2) == c && board[2].charAt(2) == c) return true;
        
        // 대각선 좌상 -> 우하
        if(board[0].charAt(0) ==c && board[1].charAt(1) == c && board[2].charAt(2) ==c) return true;
        
        // 대각선 우상 -> 좌하
        if(board[0].charAt(2) ==c && board[1].charAt(1) ==c && board[2].charAt(0) ==c) return true;
        
        return false;
    }
}