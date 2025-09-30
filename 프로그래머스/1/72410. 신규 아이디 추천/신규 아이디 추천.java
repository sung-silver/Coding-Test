class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        // 소문자, 허용되는 문자만 추가 이때, 마침표 치환도 추가
        for(int i = 0 ; i < new_id.length() ; i++) {
            char c = new_id.charAt(i);
            if(Character.isDigit(c)) {
                sb.append(c);
            } else if(Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
            else if( c == '.' ||  c == '-' || c == '_') {
                if(i != 0 && sb.length() > 0) {
                    char before = sb.charAt(sb.length() - 1);
                    if(before == '.' && c == '.') {
                        continue;
                    }
                }
                sb.append(c);
            }
        }
        
        // 맨 앞뒤 문자가 마침표라면 제거
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (sb.length() == 0) {
            sb.append('a');
        }
        
        if(sb.length() > 15) {
            sb.setLength(15);

            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        while(sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        answer = sb.toString();

        return answer;
    }
}