package dp;

public class LongestPalindromicSubsequenceRecursive {

    public int longest(String s) {
        return recursive(s, 0, s.length() - 1);
    }

    private int recursive(String s, int l, int r) {
        if (l == r) {
            return 1;
        }
        if (l > r) {
            return 0;
        }

        if (s.charAt(l) == s.charAt(r)) {
            return 2 + recursive(s, l + 1, r - 1);
        }

        int len1 = recursive(s, l + 1, r);
        int len2 = recursive(s, l, r - 1);

        return Math.max(len1, len2);
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequenceRecursive solver = new LongestPalindromicSubsequenceRecursive();
        System.out.println(solver.longest("aabbaa")); // 6
        System.out.println(solver.longest("abcd")); //1
        System.out.println(solver.longest("abcdedff")); // 3
        System.out.println(solver.longest(""));
    }
}
