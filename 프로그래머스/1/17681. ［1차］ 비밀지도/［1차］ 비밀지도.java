class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // n*n 지도를 3개 선언
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        char[][] finalMap = new char[n][n];
        
        // 입력 값을 바탕으로 지도 1을 채운다
        // fillMap -> 십진수가 입력되면 이진수로 변환한다
        for(int i=0 ; i<n ; i++) {
            String binary = convertBinary(arr1[i], n);
            for(int j=0 ; j<n ; j++) {
                map1[i][j] = binary.charAt(j) - '0';
            }
        }
        
        // 입력 값을 바탕으로 지도 2를 채운다
        for(int i=0 ; i<n ; i++) {
            String binary = convertBinary(arr2[i], n);
            for(int j=0 ; j<n ; j++) {
                map2[i][j] = binary.charAt(j) - '0';
            }
        }
        
        // 이중 포문을 돌아 최종 지도를 완성한다
        // 가로 한줄의 계산이 끝나면 String에 add한 내용을 answer에 하나씩 저장한다
        for(int i=0 ; i<n ; i++) {
            String line = "";
            for(int j=0 ; j<n ; j++) {
                int isWall = map1[i][j] + map2[i][j];
                if(isWall > 0) {
                    line += "#";
                } else {
                    line += " ";
                }
            }
            answer[i] = line;
        }
        

        return answer;
    }
    
    String convertBinary(int number, int n) {
        String result = "";
        int div = number;
        int mod = 0;
        while(div != 0) {
            mod = div % 2;
            div /= 2;
            result = mod + result;
        }
        if(result.length() < n) {
            String prefix = "0".repeat(n-result.length());
            result = prefix + result;
        }
        return result;
    }
}