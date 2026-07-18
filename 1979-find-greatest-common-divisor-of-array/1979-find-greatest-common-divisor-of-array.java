class Solution {
    public int findGCD(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int smallest = nums[0];
        int largest = nums[0];
        for(int num : nums){
            smallest = smallest > num ? num : smallest;
            largest = largest <  num ? num : largest;
        }
        while(smallest > 0){
            int temp = largest % smallest;
            largest = smallest;
            smallest = temp;
        }
        return largest;
    }
}