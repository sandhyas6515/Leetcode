class Solution {
public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
long k = (long) k1 + k2;
int n = nums1.length;
    long[] diff = new long[n];
    long max = 0;
    long total = 0;

    for (int i = 0; i < n; i++) {
        diff[i] = Math.abs((long) nums1[i] - nums2[i]);
        max = Math.max(max, diff[i]);
        total += diff[i];
    }

    if (total <= k) {
        return 0;
    }

    long low = 0;
    long high = max;

    while (low < high) {
        long mid = (low + high) / 2;
        long operations = 0;

        for (int i = 0; i < n; i++) {
            if (diff[i] > mid) {
                operations += diff[i] - mid;
            }
        }

        if (operations <= k) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }

    long remaining = k;

    for (int i = 0; i < n; i++) {
        if (diff[i] > low) {
            remaining -= diff[i] - low;
            diff[i] = low;
        }
    }

    long answer = 0;

    for (int i = 0; i < n; i++) {
        answer += diff[i] * diff[i];
    }

    for (int i = 0; i < n && remaining > 0; i++) {
        if (diff[i] == low && low > 0) {
            answer -= low * low;
            answer += (low - 1) * (low - 1);
            remaining--;
        }
    }

    return answer;
}

}
