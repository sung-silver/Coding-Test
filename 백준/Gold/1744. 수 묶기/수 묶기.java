import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array;
        int n = 0, i = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        array = new int[n];

        for(i=0;i<n;i++)	array[i] = scanner.nextInt();
        System.out.println(maxSOP(array));
    }

    public static int maxSOP(int[] array) {
        int sum = 0;
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;
        int N = array.length;
        int negative[];
        int positive[];

        for (int num : array) {
            if (num < 1) {
                if (num == 0) {
                    zeroCount++;
                } else {
                    negativeCount++;
                }
            } else {
                positiveCount++;
            }
        }

        mergeSort(array, 0, N - 1);
        negative = new int[negativeCount+zeroCount];
        positive = new int[positiveCount];

        int l = negativeCount+zeroCount;
        for (int i = 0; i < negativeCount+zeroCount;i++) {
            negative[i] = array[--l];
        }
        for(int k=0;k<positiveCount;k++) {
            positive[k] = array[k+negativeCount+zeroCount];
        }

        int idx = zeroCount+negativeCount;
        while (idx> 0) {
            if (negativeCount == 1||idx==1) {
                if (zeroCount > 0) {
                    zeroCount--;
                    negativeCount--;
                } else {
                    sum += negative[--idx];
                    negativeCount--;
                }
            } else {
                sum += negative[--idx] * negative[--idx];
                negativeCount -= 2;
            }
        }

        while (positiveCount > 0) {
            if (positiveCount == 1) {
                sum += positive[--positiveCount];
                break;
            }
            int temp = positive[--positiveCount];
            int temp2 = positive[--positiveCount];
            if (temp * temp2 > temp + temp2) {
                sum += temp * temp2;
            } else {
                sum += temp + temp2;
            }
        }

        return sum;
    }

    private static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

}

