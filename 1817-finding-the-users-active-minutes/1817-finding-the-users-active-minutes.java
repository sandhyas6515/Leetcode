class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();
        for(int[] log : logs){
            int id = log[0];
            int time = log[1];
            if(!mp.containsKey(id)){
                mp.put(id, new HashSet<>());
            }
            mp.get(id).add(time);
        }
        int[] ans = new int[k + 1];
        for(int id : mp.keySet()){
            int uam = mp.get(id).size();
            ans[uam]++;
        }
        int[] result = new int[k];
        for(int i = 1; i <= k; i++){
            result[i - 1] = ans[i];
        }
        return result;
    }
}