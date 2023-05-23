import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int w, h, n;

        for(int i=0;i<tc;i++){
            h = sc.nextInt();
            w = sc.nextInt();
            n = sc.nextInt();
            if(n%h==0) {
                System.out.println((h*100)+(n/h));
            }
            else {
                System.out.println((n%h)*100 + ((n/h)+1));
            }
        }
    }
}