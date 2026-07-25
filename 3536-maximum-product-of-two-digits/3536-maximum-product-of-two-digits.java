class Solution {
    public int maxProduct(int n) {
        int maxdigit1 =  0;
        int maxdigit2 = 0;
        while(n > 0){
            int d = n % 10;
            if(maxdigit1 < d){
                maxdigit2 = maxdigit1;
                maxdigit1 = d;
            } else if(maxdigit2 < d){
                maxdigit2 = d;
            }
            n /= 10;
        }
        return maxdigit1 * maxdigit2;
    }
}