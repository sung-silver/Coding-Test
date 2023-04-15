import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        String scores;
        String[] score;
        int max=0;
        double total=0;

        T = sc.nextInt();
        sc.nextLine();
        scores = sc.nextLine();
        score = scores.split(" ");

        for(int i=0; i<T; i++){
            if(max<Integer.valueOf(score[i])){
                max = Integer.valueOf(score[i]);
            }
        }

        for(int i=0;i<T;i++){
            total += ((Double.valueOf(score[i])/max)*100);
        }

        System.out.println(total/T);
        sc.close();
    }
}