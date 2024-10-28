/*You are given an integer array nums. A subsequence of nums is called a square streak if:

The length of the subsequence is at least 2, and
after sorting the subsequence, each element (except the first element) is the square of the previous number.
Return the length of the longest square streak in nums, or return -1 if there is no square streak.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.*/

class Streak {
    public int longestSquareStreak(int[] nums) {
          //Arrays.sort(nums);
        Set<Long> set=new HashSet<>();
          int maxcnt=-1;

          int n=nums.length;
          for(int num:nums)
          {
            set.add((long)num);
          }
          for(int num:nums)
          {
            long current=num;
            int cnt=1;
            while(set.contains(current*current))
            {
                current=current*current;
                cnt++;
            }
            if(cnt>=2)
              maxcnt=Math.max(cnt,maxcnt);
            
          }
        return maxcnt;
    }
}
