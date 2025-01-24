class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[]=new int[n];
        Arrays.fill(indegree,0);
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<n;i++) {
            for(int j:graph[i]){
                adj.get(j).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0)q.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}