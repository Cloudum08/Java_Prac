/*A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.*/



import java.util.Arrays;

class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int[][] z = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            z[i][0] = i;
            z[i][1] = nums[i];
        }
        
        Arrays.sort(z, (a, b) -> Integer.compare(a[1], b[1]));
        
        int maxWidth = 0;
        int minIndex = Integer.MAX_VALUE;
        
        for (int[] pair : z) {
            int index = pair[0];
            maxWidth = Math.max(maxWidth, index - minIndex);
            minIndex = Math.min(minIndex, index);
        }
        
        return maxWidth;
    }
}