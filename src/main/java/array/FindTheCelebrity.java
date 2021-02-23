package array;

/**
 * No.277 Find the celebrity.
 *
 * Date: 02/22/2021
 */
public class FindTheCelebrity {

    /**
     * Brute force approach.
     *
     * time: O(n^2)
     * space: O(1)
     */
    public int findCelebrityBruteForce(int n) {
        outer: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // for i, if it knows anyone else, or anyone doesn't know him,
                // then i can be ruled out
                if (knows(i, j) || !knows(j, i)) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    /**
     * By calling knows(a, b), we can definitively rule out 1 person:
     * if true, then a can't be celebrity, we can use b as candidate to check the rest;
     * if false, b can't be celebrity, use a as candidate.
     *
     * time: O(n)
     */
    public int findCelebrity(int n) {
        // narrow the celebrity down to 1 person
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (i == candidate) continue;
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // check if this person is celebrity
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }

    /**
     * API for checking if a knows b.
     * Return true if a knows b, else return false.
     */
    public boolean knows(int a, int b) {
        // no implementation
        return false;
    }
}
