import java.util.*;
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long num =0;
        long number=0;
        long list[] = {0,0};

        num = sc.nextInt();
        number = num;


        if(num==0){
            number = 1;
        }

        else {
            for(int i=1;i<=number;i++){
                int compare = i;
                while(compare%2==0){
                    compare/=2;
                    list[0]++;
                }
                while(compare%5==0){
                    compare/=5;
                    list[1]++;
                }
            }
        }

        System.out.println(Math.min(list[0],list[1]));

    }
}