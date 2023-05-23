import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x, y, z;
        double a, b, c; // 빗변을 c라고 가정한다

        while(true) {
            x = sc.nextDouble();
            y = sc.nextDouble();
            z = sc.nextDouble();

            // 입력값이 0, 0, 0이면 탈출
            if(x == 0 && y ==0 && z==0) break;
            // 가장 긴 변이 되는 빗변을 찾는다
            if(x>=y && x>=z){
                c = x;
                a = y;
                b = z;
            }
            else if (y>=x && y>=z){
                c = y;
                a = x;
                b = z;
            }
            else{
                c = z;
                a = x;
                b = y;
            }
            // 직각삼각형은 피타고라스 정리를 만족한다
            if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}