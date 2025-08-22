import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(String line : record) {
            String[] command = line.split(" ");
            String op = command[0];
            String id = command[1];
            if(op.equals("Enter") || op.equals("Change")) {
                String nickname = command[2];
                map.put(id, nickname);
            }
        }
        
        for(String line : record) {
            String[] command = line.split(" ");
            String op = command[0];
            String id = command[1];
            String nickname = map.get(id);
            if(op.equals("Enter")) {
                arr.add(nickname+"님이 들어왔습니다.");   
            }
            else if(op.equals("Leave")) {
                arr.add(nickname+"님이 나갔습니다.");  
            }
        }
        
        return arr.toArray(new String[arr.size()]);
    }
}