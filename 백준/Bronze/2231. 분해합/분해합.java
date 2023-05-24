import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1;
        int tmp=0;

        for(int i=1;i<N;i++) {
            sum = i; // 부분합은 생성자 + 생성자의 자릿수의 합이므로 미리 생성자라고 가정한 숫자를 더해둔다
            tmp = i;
            while (tmp>0) { // 나눈 몫이 0이면 모든 자리를 더한 것이므로 탈출한다
                sum += tmp%10;
                tmp /= 10;
            }

            if(sum==N){ // 입력했던 부분합과 해당 생성자의 부분합이 같다면 생성자를 출력한다
                System.out.println(i);
                return;
            }

        }

        System.out.println(0);
    }
}