class Solution {
    public int minimumSwaps(int[] nums) {
        int zeroCount = 0;
        for(int num : nums){
            if(num == 0){
                zeroCount++;
            }
        }
        int ans = 0;
        for(int i = nums.length - zeroCount; i < nums.length; i++){
            if(nums[i] != 0){
                ans++;
            }
        }
        return ans;
    }
}