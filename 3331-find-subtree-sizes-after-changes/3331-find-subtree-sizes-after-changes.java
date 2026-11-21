class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];
        for(int i = 0; i < n; i++){
            children[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++){
            children[parent[i]].add(i);
        }
        int[] newParent = parent.clone();
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int[] previous = new int[n];
        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;
        while(top > 0){
            int value = stack[--top];
            if(value < 0){
                int node = -value - 1;
                int ch = s.charAt(node) - 'a';
                lastSeen[ch] = previous[node];
                continue;
            }
            int node = value;
            int ch = s.charAt(node) - 'a';
            previous[node] = lastSeen[ch];
            if(node != 0 && lastSeen[ch] != -1){
                newParent[node] = lastSeen[ch];
            }
            lastSeen[ch] = node;
            stack[top++] = -(node + 1);
            for (int i = children[node].size() - 1; i >= 0; i--) {
                stack[top++] = children[node].get(i);
            }
        }
        List<Integer>[] newChildren = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }
        int[] order = new int[n];
        int index = 0;
        stack[top++] = 0;
        while (top > 0) {
            int node = stack[--top];
            order[index++] = node;
            for (int child : newChildren[node]) {
                stack[top++] = child;
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }
        return ans;
        }
    }