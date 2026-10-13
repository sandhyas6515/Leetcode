class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n < 4){
            return new ArrayList<>();
        }
        Set<List<Integer>> uniquequad = new HashSet<>();
        for(int first = 0; first < n - 3; first++){
            for(int second = first + 1; second < n - 2; second++){
                Set<Long> seenValues = new HashSet<>();
                for(int third = second + 1; third < n; third++){
                    long fourthValue = (long) target - nums[first] - nums[second] - nums[third];
                    if(seenValues.contains(fourthValue)){
                        List<Integer> quad = new ArrayList<>(
                            Arrays.asList(
                                nums[first], nums[second], nums[third], (int) fourthValue
                            )
                        );
                        Collections.sort(quad);
                        uniquequad.add(quad);
                    }
                    seenValues.add((long) nums[third]);
                }
            }
        }
        return new ArrayList<>(uniquequad);
    }
}