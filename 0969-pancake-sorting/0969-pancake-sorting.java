class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex == i) {
                continue;
            }
            if (maxIndex != 0) {
                reverse(arr, maxIndex);
                ans.add(maxIndex + 1);
            }
            reverse(arr, i);
            ans.add(i + 1);
        }
        return ans;
    }
    private void reverse(int[] arr, int k) {
        int left = 0;
        int right = k;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}