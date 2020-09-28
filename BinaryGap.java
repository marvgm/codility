import java.util.Arrays;

public class BinaryGap {

 /*   A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary
    representation of N.
    For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary
        representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary
        representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
    The number 32 has binary representation 100000 and has no binary gaps.

    Write a function:
    class Solution { public int solution(int N); }
    that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
    For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
    Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
    Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..2,147,483,647].*/

    public static void main (String [] args){
        int A = 1041;

        //n=51712=110010100000000_2 and n=20=10100_2✘WRONG ANSWER got 9 expected 2
        //n=6=110_2 and n=328=101001000_2✘ WRONG ANSWER got 1 expected 0

        System.out.println(solution(A));
    }

    public static int solution(int N) {
        if (N <= 0){
            return 0;
        }

        String binario = Integer.toBinaryString(N);

        binario = retornaBinarioValido(binario);

        String[] parts1 = binario.split("1");

        if(parts1.length == 0)
            return 0;

        int maior = parts1[0].length();

        for(int i=1 ; i < parts1.length; i++)
        {
            if(maior < parts1[i].length())
            {
                maior = parts1[i].length();
            }

        }

        return maior;
    }

    public static String retornaBinarioValido(String str){
        if( str.endsWith("1")) {
            return str;
        }

        int lastIndex= str.lastIndexOf("1");

        return str.substring(0, lastIndex );
    }
}
