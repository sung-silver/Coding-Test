import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<String> afterCase = new ArrayList<>(s.length());
        if(Character.isDigit(s.charAt(0))){
            afterCase.add(String.valueOf(s.charAt(0)).toLowerCase());
        }
        else{
            afterCase.add(String.valueOf(s.charAt(0)).toUpperCase());
        }
        for(int i=1;i<s.length();i++)
        {
            if(afterCase.get(i-1).equals(" ")){
                afterCase.add(String.valueOf(s.charAt(i)).toUpperCase());
            }
            else{
                afterCase.add(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }

            for(String item:afterCase){
                answer+=item;
            }
        return answer;
    }
}