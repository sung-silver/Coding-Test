import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        int M;
        int number;
        int start;
        int end;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int[] sum = new int[N+1];

        for(int i=1; i<N+1; i++){
            sum[i]=sum[i-1]+sc.nextInt();
        }
        
        for(int j=0; j<M ; j++){
            start = sc.nextInt();
            end = sc.nextInt();
            System.out.println(sum[end]-sum[start-1]);
        }
    }
}