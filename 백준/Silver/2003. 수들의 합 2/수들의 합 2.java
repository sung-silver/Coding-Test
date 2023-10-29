import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        long sum=0;
        int start=0;
        int end=0;

        long[] number = new long[N+1];

        for(int i = 0; i < N; i++) {
            number[i] = sc.nextLong();
        }

        while(end<=N){
            if(sum>=M){
                sum-=number[start++];
            }
            if(sum<M){
                sum+=number[end++];
            }
            if(sum==M){
                count++;
            }
        }
        System.out.println(count);
    }
}
