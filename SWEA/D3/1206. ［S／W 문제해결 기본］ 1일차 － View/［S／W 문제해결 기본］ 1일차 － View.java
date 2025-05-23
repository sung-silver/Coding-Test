import java.util.*;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int count = 0;
            int houseCount= sc.nextInt();
            sc.nextLine();
            int[] houses = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int i=2 ; i < houseCount-2 ;  i++) {
                int currentHeight = houses[i];
                int leftHeightMax = Math.max(houses[i-2], houses[i-1]);
                int rightHeightMax = Math.max(houses[i+1], houses[i+2]);
                int sightRange = Math.max(leftHeightMax , rightHeightMax);
                int availableHouseHeight= currentHeight - sightRange;
                if(availableHouseHeight > 0)
                    count += availableHouseHeight;
            }

            System.out.println("#"+test_case+" "+count);
        }
    }
}