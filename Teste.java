import java.util.*;

public class Teste {

    public static void main (String [] args){
        int[] A = {1,2,3};

        System.out.println(solution(A));
    }

    public static int solution(int[] arr) {
        int smallestInt = 1;

        if (arr.length == 0)
            return smallestInt;

        Arrays.sort(arr);

        if (arr[0] > 1)
            return smallestInt;

        if (arr[arr.length - 1] <= 0)
            return smallestInt;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == smallestInt) {
                smallestInt++;
            }
        }

        return smallestInt;
    }
}
