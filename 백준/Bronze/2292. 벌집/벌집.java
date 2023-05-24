import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long count=0;
        long i=0;
        long room=N-1;
        if(N==1){
            count = 1;
        }
        else {
            while (room > 0) {
                room -= i;
                count++;
                i += 6; // 벌집은 1 - 6 - 12 - 18 - 24 (6의 배수로 가장 바깥쪽 테두리의 개수가 증가한다)
            }
        }

        System.out.println(count);
    }
}