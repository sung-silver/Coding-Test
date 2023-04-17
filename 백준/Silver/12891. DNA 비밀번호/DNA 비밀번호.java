import java.util.Scanner;

public class Main {

    static int[] compareDNA = new int[4]; // 0: A, 1: C, 2: G, 3: T
    static int[] countDNA = new int[4];

    static boolean compareCount(){
        if((compareDNA[0]<=countDNA[0])&&(compareDNA[1]<=countDNA[1])&&(compareDNA[2]<=countDNA[2])&&(compareDNA[3]<=countDNA[3]))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] PW;
        int S;
        int P;
        String DNA;
        int start,end;
        int count=0;

        S = sc.nextInt();
        P = sc.nextInt();
        sc.nextLine();
        DNA = sc.nextLine();
        PW = DNA.toCharArray();

        for(int i=0;i<4;i++){
            compareDNA[i] = sc.nextInt();
            countDNA[i]=0;
        }

        for(int i=0; i<P ; i++){
            switch(PW[i]){
                case 'A': countDNA[0]++; break;
                case 'C': countDNA[1]++; break;
                case 'G': countDNA[2]++; break;
                case 'T': countDNA[3]++; break;
            }
        }
        if(compareCount()) count++;

        start = 1;
        end = P;

        while(end<S){
            switch(PW[start-1]){
                case 'A': countDNA[0]--; break;
                case 'C': countDNA[1]--; break;
                case 'G': countDNA[2]--; break;
                case 'T': countDNA[3]--; break;
            }
            switch(PW[end]){
                case 'A': countDNA[0]++; break;
                case 'C': countDNA[1]++; break;
                case 'G': countDNA[2]++; break;
                case 'T': countDNA[3]++; break;
            }

            if(compareCount()) count++;

            start++;
            end++;
        }

        System.out.println(count);
        sc.close();
    }
}