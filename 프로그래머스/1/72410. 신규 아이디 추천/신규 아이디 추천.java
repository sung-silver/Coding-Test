import java.util.*;

class Solution {
    public String solution(String new_id) {
         // 1. 소문자로 변환
        String s = new_id.toLowerCase();

        // 2~3. 허용된 문자만 남기고, '.' 연속 처리
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.') {
                if (c == '.' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
                    continue; // 연속된 '.' 무시
                }
                sb.append(c);
            }
        }

        // 4. 앞뒤 '.' 제거
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 5. 빈 문자열이면 "a"
        if (sb.length() == 0) {
            sb.append("a");
        }

        // 6. 길이가 16 이상이면 15자로 자르고, 끝이 '.'이면 제거
        if (sb.length() >= 16) {
            sb.setLength(15); // substring(0,15) 대신
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        // 7. 길이가 2 이하라면 마지막 문자 반복
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}