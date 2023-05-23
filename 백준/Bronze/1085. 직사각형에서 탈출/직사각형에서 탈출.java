import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y, w, h;
        int width, height;
        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();

        // 가로 각 변과 현재 위치의 거리를 비교한다
        if(x>w-x){
            width = w-x;
        }
        else{
            width = x;
        }

        // 세로 각 변과 현재 위치의 거리를 비교한다
        if(y>h-y){
            height = h-y;
        }
        else{
            height = y;
        }

        // 가로로 도착할 수 있는 최소 거리와 세로로 도착할 수 있는 최소거리를 비교한다
        if(width>height){
            System.out.println(height);
        }
        else{
            System.out.println(width);
        }
    }
}