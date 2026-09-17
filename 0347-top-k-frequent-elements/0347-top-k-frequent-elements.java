class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List <List <Integer>> bucket = new ArrayList<>();

        for(int i = 0; i <= nums.length; i++){
        bucket.add(new ArrayList<>());
        }
        for(int x : map.keySet()){
            int freq = map.get(x);
            bucket.get(freq).add(x);
        }
        int[] ans = new int[k];
        int index = 0;
        for(int i = nums.length; i >= 1 && index < k;i--){
            for(int x : bucket.get(i)){
                ans[index++] = x;
                if(index == k){
                    break;
                }
            }
        }
        return ans;
    }
}