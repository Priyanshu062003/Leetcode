class Solution {
    void dfs(int i, List<List<Integer>> adj, boolean visit[], int[] temp) {
        if(visit[i])return ;
        visit[i] = true;
        temp[0]++;
        temp[1] += adj.get(i).size();
        for(int j: adj.get(i)) {
            dfs(j,adj,visit,temp);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i[]: edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        boolean visit[] = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(visit[i] != true) {
                int temp[] = {0,0};
                dfs(i,adj,visit,temp);
                if(temp[0]*(temp[0]-1) == temp[1]) ans++;
            }
        }
        return ans;

    }
}