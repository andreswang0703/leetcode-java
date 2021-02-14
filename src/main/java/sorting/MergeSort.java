package sorting;

import java.util.Arrays;

/**
 * This is top-down mergesort implementation.
 *
 * time: O(nlogn)
 * space: O(n) - linear auxiliary array
 *
 * Date: 02/14/2021
 */
public class MergeSort {

    private static Comparable[] aux;

    /**
     * Sort the array in-place.
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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
