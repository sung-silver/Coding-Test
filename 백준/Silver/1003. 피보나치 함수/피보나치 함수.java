import java.util.*;
public class Main {

    static Scanner sc = new Scanner(System.in);

    static class Fibo{
        int zeroCount=0;
        int oneCount=0;
        public Fibo(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }
    }
    public static void main(String[] args) {
        int TC = 0;
        int number =0;
        Fibo[] fibos = new Fibo[41];
        fibos[0] = new Fibo(1,0);
        fibos[1] = new Fibo(0,1);

        for(int i=2;i<=40;i++){
            fibos[i] = new Fibo(fibos[i-1].zeroCount+fibos[i-2].zeroCount, fibos[i-1].oneCount+fibos[i-2].oneCount);
        }

        TC = sc.nextInt();

        for(int j=0;j<TC;j++){
            number = sc.nextInt();
            System.out.println(fibos[number].zeroCount+" "+fibos[number].oneCount);
        }
    }
}