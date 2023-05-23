import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int count =0;
        for(int i=0;i<tc;i++){
            count+= isPrime(sc.nextInt());
        }
        System.out.println(count);
    }

     public static int isPrime(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        for(int i=2; i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                return 0;
            }
        }
        return 1;
    }
}