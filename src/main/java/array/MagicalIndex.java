package array;

/**
 * Cracking the Code Interview CH8.3 Magic Index
 *
 * Given a sorted array nums, the magic index is where nums[i] == i.
 *
 * Date: 02/01/2021
 */
public class MagicalIndex {

    /**
     * The given array is sorted, and numbers are unique.
     */
    public int getMagicalIndexUnique(int[] nums) {

        // when range of index doesn't intersect with range of values
        if (nums[0] > nums.length - 1 || nums[nums.length - 1] < 0) {
            return -1;
        }

        // find intersection of two ranges
        int lo = Math.max(0, nums[0]);
        int hi = Math.min(nums.length - 1, nums[nums.length - 1]);

        /*
         * using iterative to always explore one of the two sides
         * because there's always only one possibility, given that
         * the value always increase/decrease faster than the index
         * nums[mid] < mid, go right
         * nums[mid] > mid, go left
         */
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == nums[mid]) {
                return mid;
            } else if (nums[mid] < mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    /**
     * The given array is sorted, but possibly contains duplicates.
     */
    public int getMagicalIndex(int[] nums) {
        return indexHelper(nums, 0, nums.length - 1);
    }

    private int indexHelper(int[] nums, int lo, int hi) {
        System.out.println(lo + ", " + hi);
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == mid) {
            return mid;
        }

        /*
         * compared to when nums are unique(iterative), this needs to explore both branches,
         * since both sides are possible.
         *
         * However the search range is reduced, because if nums[mid] < mid,
         * then magic index can not possibly be in range (nums[mid], mid];
         * similarly, if nums[mid] > mid, range [mid, nums[mid]) can be eliminated.
         *
         * This can be seen in a simple example.
         */
        int leftHi = Math.min(nums[mid], mid - 1);
        int rightLo = Math.max(nums[mid], mid + 1);

        int left = indexHelper(nums, lo, leftHi);
        if (left != -1) {
            return left;
        } else {
            return indexHelper(nums, rightLo, hi);
        }
    }

    public static void main(String[] args) {
        MagicalIndex magicalIndex = new MagicalIndex();

        int[] numsUnique = new int[]{-7, -4, 2, 4, 5, 7, 10, 15};
        int res = magicalIndex.getMagicalIndexUnique(numsUnique);
        System.out.println(res);

        int[] nums = new int[]{-7, -2, 2, 5, 5, 6, 6, 7};
        int res1 = magicalIndex.getMagicalIndex(nums);
        System.out.println(res1);
    }
}
