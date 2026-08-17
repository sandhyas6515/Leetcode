class Solution {
    private int sumByD(int[] arr , int div){
        int sum = 0;
        for(int num : arr){
            sum += Math.ceil((double) num / div);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num : nums){
            high = Math.max(high , num);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            int sum = sumByD(nums, mid);
            if(sum <= threshold){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}