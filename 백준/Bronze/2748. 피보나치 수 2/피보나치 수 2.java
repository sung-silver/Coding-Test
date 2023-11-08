import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long a=0;
        long b=1;
        long c=0;
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        
        if (n <= 1) {
            System.out.println(1);
        }
        else {
            for (int i = 0; i < n - 1; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println(c);
        }
    }
}
