class Solution {
    public long maxAlternatingSum(int[] nums) {
        long sum = 0;
        int n = nums.length;
        long[] squares = new long[n];
        for(int i = 0; i < nums.length; i++){
            squares[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(squares);
        long result = 0;
        int half = n / 2;
        for(int i = 0; i < n; i++){
            if(i < half){
                result -= squares[i];
            } else {
                result += squares[i];
                }
            }
        return result;
    }
}