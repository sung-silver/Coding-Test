import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        int[][] APT = new int[15][15];

        for (int i = 0; i < 15; i++) {
            APT[i][1] = 1; 
            APT[0][i] = i; 
        }

        for (int i = 1; i < 15; i++) {

            for (int j = 2; j < 15; j++) {
                APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
            }
        }
        
        for(int i=0;i<n;i++){
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(APT[k][m]);
        }
        
    }
}
