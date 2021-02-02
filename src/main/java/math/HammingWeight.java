package math;

/**
 * No.191 Number of 1 bits. (easy)
 *
 * Given an integer, return the number of 1 bits in its binary representation.
 *
 * e.g.
 * input: -3 (binary 11111111111111111111111111111101)
 * output: 31 (total of 31 1s)
 *
 * Date: 02/02/2021
 *
 */
public class HammingWeight {

    public int getHammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        int input = -3;  // 11111111111111111111111111111101
        int res = hammingWeight.getHammingWeight(input);
        System.out.println(res);  // 31

        int input2 = 3;  // 00000000000000000000000000000011
        int res2 = hammingWeight.getHammingWeight(input2);
        System.out.println(res2);  // 3
    }
}
