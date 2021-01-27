package array;

/**
 * No.75 Sort Colors. (medium)
 *
 *
 * Date: 01/26/2021
 */
public class SortColors {

    /**
     * Dutch national flag problem: https://en.wikipedia.org/wiki/Dutch_national_flag_problem
     *
     * time: O(n)
     * space: O(1)
     */
    public void sortColors(int[] arr) {
        int p0 = 0;
        int p2 = arr.length - 1;
        int cur = 0;

        while (cur <= p2) {
            if (arr[cur] == 0) {
                swap(arr, p0, cur);
                p0++;
                cur++; // todo: why is this important???
            } else if (arr[cur] == 2) {
                swap(arr, p2, cur);
                p2--;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    // todo: brute force
}
