package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * No.287 Find the duplicate number. (medium)
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 *
 * date: 02/23/2021
 */
public class FindTheDuplicateNumber {

    /**
     * time: O(nlogn) - sorting
     * space: O(1)
     */
    public int findDuplicateBySorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find duplicate using helping hashset.
     *
     * time: O(n)
     * space: O(n)
     */
    public int findDuplicateUsingSet(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (seen.contains(n)) {
                return n;
            }
            seen.add(n);
        }
        return -1;
    }

    /**
     * Find duplicate using Floyd's tortoise and hare algorithm (cycle detection).
     * Reference: https://leetcode.com/problems/find-the-duplicate-number/solution/
     *
     * time: O(n)
     * space: O(1)
     */
    public int findDuplicateOptimized(int[] nums) {
        int s = nums[0];
        int f = nums[0];

        do {
            s = nums[s];
            f = nums[nums[f]];
        } while (s != f);

        s = nums[0];
        while (s != f) {
            s = nums[s];
            f = nums[f];
        }

        return s;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber find = new FindTheDuplicateNumber();
        int[] nums = new int[]{4,2,6,5,3,7,4,1,8};
        System.out.println(find.findDuplicateBySorting(nums));
        System.out.println(find.findDuplicateUsingSet(nums));
        System.out.println(find.findDuplicateOptimized(nums));
    }
}
