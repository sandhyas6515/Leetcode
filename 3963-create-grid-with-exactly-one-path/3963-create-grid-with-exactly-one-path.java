class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        String r1 = ".".repeat(n);
        res[0] = r1;
        String r = "#".repeat(n - 1) + ".";
        for(int i = 1; i < m; i++){
            res[i] = r;
        }
        return res;
    }
}