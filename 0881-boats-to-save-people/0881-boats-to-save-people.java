class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0;
        int r = people.length - 1;
        int res = 0;
        Arrays.sort(people);
        while(l <= r){
            int remain = limit - people[r];
            r -= 1;
            res += 1;
            if(l <= r && remain >= people[l]){
                l += 1;
            }
        }
        return res;
    }
}