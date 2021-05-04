package dp;

public class PalindromePartitioning {

    public int partition(String s) {
        return recursive(s, 0, s.length() - 1);
    }

    private int recursive(String s, int l, int r) {
        if (l >= r || isPalindrome(s, l, r)) {
            return 0;
        }

        int minCut = r - l; // max possible cut: len - 1
        for (int i = l; i < r; i++) {
            if (isPalindrome(s, l, i)) {
                minCut = Math.min(minCut, 1 + recursive(s, i + 1, r));
            }
        }
        return minCut;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        PalindromePartitioning solver = new PalindromePartitioning();
        System.out.println(solver.partition(s));
    }
}
