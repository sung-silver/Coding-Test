import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        int M;
        Scanner sc = new Scanner(System.in);
        int[] array;
        int start;
        int end;
        int count;

        N = sc.nextInt();
        M = sc.nextInt();

        array = new int[N];

        for(int i=0;i<N;i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        start = 0;
        end = N-1;
        count = 0;

        while(start<end){
            if((array[start]+array[end])<M){
                start++;
            }
            else if((array[start]+array[end])>M){
                end--;
            }
            else{
                count ++;
                start++;
                end--;
            }
        }
        System.out.println(count);
        sc.close();
    }
}