class Solution {
    int ans = 0;
    long dfs(int node, List<List<Integer>> adj, int parent, int[] values, int k) {
        long sum = (values[node]+0L);

        for(int i: adj.get(node)) {
            if(i == parent) continue;
            sum = (sum + dfs(i,adj,node,values,k));
        }
        if(sum%k == 0) ans++;
        return sum;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i[]: edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        dfs(0,adj,-1,values,k);
        return ans;
    }
}