import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] list;
        int N = sc.nextInt();
        list = new int[N];

        for(int i=0;i<N;i++){
            list[i] = sc.nextInt();
        }

        mergeSort(list, 0, N-1);

        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }


    }

    private static void mergeSort(int[] a, int left, int right) {
        if(left<right){
            int mid = (left+right)/2; // 데이터 리스트의 중앙 인덱스를 구함
            mergeSort(a, left, mid); // 중앙을 기준으로 왼쪽 데이터를 분할 -> 재귀호출로 원소가 하나 남을 때까지 진행
            mergeSort(a, mid+1, right); // 중앙을 기준으로 오른쪽 데이터를 분할 // 재귀 호출로 원소가 하나 남을 때 까지 진행
            merge(a, left, mid, right); // 정복 및 결합 과정을 진행
        }
    }

    private static void merge(int[] a, int left, int mid, int right){
        // 분할된 왼쪽 리스트의 인덱스를 지정할 변수
        int leftIndex = left;
        // 분할된 오른쪽 리스트의 인덱스를 지정할 변수
        int rightIndex = mid+1;
        // 정렬된 데이터를 임시로 저장할 곳
        int[] tmplist = new int[right+1];
        // 정렬된 데이터가 담긴 리스트에서 사용된 인덱스
        int tmpIndex = left;

        // 왼쪽 정렬 완료의 기준 -> leftIndex가 mid까지 온 경우
        // 오른쪽 정렬 완료의 기준 -> rightIndex가 right까지 온 경우
        while(leftIndex<=mid || rightIndex<=right){
            if(rightIndex>right || (leftIndex<=mid && a[leftIndex]<a[rightIndex])){
                tmplist[tmpIndex++]= a[leftIndex++];
            }
            else{
                tmplist[tmpIndex++]=a[rightIndex++];
            }
        }

        for(int i=left;i<=right;i++){
            a[i] = tmplist[i];
        }

    }
}