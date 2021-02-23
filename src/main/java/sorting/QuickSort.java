package sorting;

import java.util.Arrays;

/**
 * Quick sort implementation.
 *
 * time: O(nlogn)
 * space: recursion stack: worst case O(n), average O(logn)
 *
 * Date: 02/23/2021
 */
public class QuickSort {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = partition(nums, lo, hi);
        sort(nums, lo, pivot - 1);
        sort(nums, pivot + 1, hi);
    }

    // use nums[lo] as partition element
    private int partition(int[] nums, int lo, int hi) {
        int k = nums[lo];
        int i = lo;
        int j = hi + 1;

        // beware of the breaking condition
        while (true) {
            while (nums[++i] < k) {
                if (i == hi) break;
            }
            while (nums[--j] > k) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }

        // put partition element to it's position
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{39, 4, 32, 56, 31, 98, 42, 65, 12, 5, 653, 123, 93};
        QuickSort quickSort = new QuickSort();
        quickSort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
