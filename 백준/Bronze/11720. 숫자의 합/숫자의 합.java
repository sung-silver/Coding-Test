import java.util.Scanner;

public class Main{

     public static void main(String []args){
        int N;
        String numbers;
        int total=0;
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = sc.next();
        
        for(int i=0;i<N;i++){
            total+=(numbers.charAt(i)-'0');
        }
        
        System.out.println(total);
        sc.close();
     }
}