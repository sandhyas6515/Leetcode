class Solution {
    public boolean canAliceWin(int n) {
        int stones = 10;
        while (n >= stones) {
            n -= stones;
            stones--;
            if (n < stones) {
                return true;
            }
            n -= stones;
            stones--;
        }
        return false;
    }
}