class Solution {
    static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        return (int)((power(5, even) * power(4, odd)) % MOD);
    }
    private long power(long base, long n) {
        if (n == 0) {
            return 1;
        }
        long half = power(base, n / 2);
        if (n % 2 == 0) {
            return (half * half) % MOD;
        }
        return (base * half % MOD * half) % MOD;
    }
}