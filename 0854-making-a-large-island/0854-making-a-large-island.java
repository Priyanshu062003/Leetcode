class DJS {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DJS(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
            parent.add(i);
        }
    }
    int find(int ele)
    {
        if(parent.get(ele) == ele) return ele;
        int ulp = find(parent.get(ele));
        parent.set(ele, ulp);
        return parent.get(ele);
          
	}
	void unionSet(int u, int v) {
        int parx = find(u);
        int pary = find(v);

        if (parx == pary) return;
        if (size.get(parx) < size.get(pary)) {
            parent.set(parx, pary);
            size.set(pary, size.get(pary) + size.get(parx));
        }
        else {
            parent.set(pary, parx);
            size.set(parx, size.get(parx) + size.get(pary));
        }
    }
}
class Solution {
    int n;
    boolean isValid(int row,int col) {
        if(row<0 || col<0 || row>=n || col>=n) {
            return false;
        }
        return true;
    }
    public int largestIsland(int[][] grid) {
        n = grid.length;
        DJS djs = new DJS(n*n);
        int dir[][] = {{0,-1},{-1,0},{0,1},{1,0}};

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    for(int k=0; k<4; k++) {
                        int row = i+dir[k][0];
                        int col = j+dir[k][1];
                        if(isValid(row,col) && grid[row][col] == 1)
                            djs.unionSet(i*n+j,row*n+col);
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                if (grid[i][j] == 1) continue;
                
                    int temp = 0;
                    Set<Integer> set = new HashSet<>();

                    for(int k=0; k<4; k++) {
                        int row = i+dir[k][0];
                        int col = j+dir[k][1];

                        if(isValid(row,col) && grid[row][col]==1 ) {
                            set.add(djs.find(row*n+col));
                        }   
                    }

                    for(int val: set) {
                        temp += djs.size.get(val);
                    }
                    ans = Math.max(ans,temp+1);

                
            }
        }
        ans = Math.max(ans,djs.size.get(0));
        return ans;


    }
}