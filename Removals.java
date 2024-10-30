/*You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array nums​​​, return the minimum number of elements to remove to make nums​​​ a mountain array.

 */

class Removals{
    public int minimumMountainRemovals(int[] nums) {
        int[] lis = new int[nums.length];
        int[] lds = new int[nums.length];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j] && lds[j] + 1 > lds[i]) {
                    lds[i] = lds[j] + 1;
                }
            }
            if (lis[i] > 1 && lds[i] > 1) {
                max = Math.max(lis[i] + lds[i] - 1, max);
            }
        }

        return nums.length - max;
    }
}
