class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int sum = 0;
        int product = 1;
        while(n > 0){
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n /= 10;
        }
        int ans = product + sum;
        return original % ans == 0;
    }
}