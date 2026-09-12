class Solution {
    public double separateSquares(int[][] squares) {
        double total = 0;
        for (int[] s : squares) {
            total += (double) s[2] * s[2];
        }
        double target = total / 2.0;
        double low = 0;
        double high = 0;
        for (int[] s : squares) {
            high = Math.max(high, s[1] + s[2]);
        }
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            double below = 0;
            for (int[] s : squares) {
                double y = s[1];
                double side = s[2];
                if (mid <= y) {
                    continue;
                } 
                else if (mid >= y + side) {
                    below += side * side;
                } 
                else {
                    below += side * (mid - y);
                }
            }
            if (below < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}