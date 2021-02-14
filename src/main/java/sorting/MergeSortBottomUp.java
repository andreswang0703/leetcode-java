package sorting;

import java.util.Arrays;

/**
 * Bottom up approach for merging sort (sorting by building up small sorted list to bigger ones).
 *
 * Start by merging 1-by-1, then 2-by-2, etc.
 *
 * time: O(nlogn)
 * space: O(n)
 *
 * Date: 02/14/2021
 */
public class MergeSortBottomUp {

    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        aux = new Comparable[n];

        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += 2 * len) {
                merge(arr, lo, lo + len - 1, Math.min(lo + 2 * len - 1, n - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int l = lo;
        int r = mid + 1;

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        for (int i = lo; i <= hi; i++) {
            if (l > mid) a[i] = aux[r++];
            else if (r > hi)  a[i] = aux[l++];
            else if (less(aux[r], aux[l])) a[i] = aux[r++];
            else a[i] = aux[l++];
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4,7,43,76,4,26,37,13,2,34};
        sort(input);
        Arrays.stream(input).forEach(System.out::println);
    }
}
