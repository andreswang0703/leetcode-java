package array;

/**
 * No.821. Shortest Distance to a Character. (easy)
 *
 * Given a string s and a character c that occurs in s, return an array of integers answer
 * where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
 *
 * e.g.
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 *
 * Date: 02/07/2021
 *
 */
public class ShortestDistanceToACharacter {

    /**
     * Two arrays: left and right
     * left[i] means shortest distance from char at i to char c to the left.
     */
    public int[] shortestToChar(String s, char c) {
        int pos = Integer.MIN_VALUE / 2;  // can't just use MIN_VALUE because i - pos could overflow
        int n = s.length();

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            res[i] = i - pos;
        }

        pos = Integer.MAX_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }
}
