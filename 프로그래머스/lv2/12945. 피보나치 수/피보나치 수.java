import java.util.ArrayList;
class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>(); // F(n)에 대한 나머지를 저장
        list.add(0);
        list.add(1);
        for(int i=2;i<=n;i++){
            list.add((list.get(i-1)%1234567+list.get(i-2)%1234567)%1234567);
        }

        answer = list.get(n);

        return answer;
    }
}