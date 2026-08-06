class Solution {
    public int smallestNumber(int n, int t) {
        int result = n;
        while(productOfDigits(result) % t != 0){
            result++;
        }
        return result;
    }
    public static int productOfDigits(int n){
        int product = 1;
        while(n > 0){
            product *= n % 10;
            n /= 10;
        }
        return product;
    }
}