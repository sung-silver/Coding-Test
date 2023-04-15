import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        
        int start=0, end=0;
        int sum=0, count=0;
        
        N = sc.nextInt();
        
        while(start<=N){
            while(++end<=N) {
                sum += end;
                if (sum >= N) {
                    if (sum == N) count++;
                    break;
                }
            }
            while(++start<=N){
                sum -= start;
                if(sum<=N){
                    if(sum==N) count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}