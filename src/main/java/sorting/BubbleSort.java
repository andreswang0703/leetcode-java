package sorting;

import java.util.Arrays;

/**
 * Bubble sort implementation.
 *
 * Date: 03/02/2021
 */
public class BubbleSort {

    /**
     * time: O(n^2)
     * space: O(1)
     */
    public void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {

            // upper bound: n-i-1, because last i are sorted
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,8,6,2,1,9,32,21,11,-3,-6,14,-9};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
