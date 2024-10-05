//Given an array of integers nums and an integer target, return indices of //the two numbers such that they add up to target.

//You may assume that each input would have exactly one solution, and you //may not use the same element twice.

class Solution {

   
    public int[] twoSum(int[] nums, int target) {

       
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        
        
        int sizeOfArray = nums.length;

        
        for(int i = 0; i < sizeOfArray; i++) {
          
            int diff = target - nums[i];

            // Check if the difference already exists in the map
            if(numToIndexMap.containsKey(diff)) {
               
                return new int[]{i, numToIndexMap.get(diff)};
            }

            
            numToIndexMap.put(nums[i], i);
        }

        
        return null;
    }
}