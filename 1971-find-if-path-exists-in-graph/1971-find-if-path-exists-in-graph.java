class Solution {
    public boolean dfs(int node , int destination, ArrayList<Integer> [] adj, boolean[] visited){
        if(node == destination)
            return true;
        visited[node] = true;
        for(int neigh : adj[node]){
            if(!visited[neigh]){
                if(dfs(neigh, destination, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer> [] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }
}