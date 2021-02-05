package array;

import java.util.HashMap;
import java.util.Map;

/**
 * No.594. Longest Harmonious Subsequence (easy)
 *
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 *
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 */
public class LongestHarmoniousSubsequence {

    /**
     * time: O(n)
     * space: O(n)
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int num : countMap.keySet()) {
            if (countMap.containsKey(num + 1)) {
                res = Math.max(res, countMap.get(num) + countMap.get(num + 1));
            }
        }
        return res;
    }
}
