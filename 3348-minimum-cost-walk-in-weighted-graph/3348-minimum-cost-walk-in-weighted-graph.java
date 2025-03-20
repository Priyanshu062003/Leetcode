class Solution {
    private int[] p;
    private int[] r;
    private int[] c;

    public int[] minimumCost(int n, int[][] e, int[][] q) {
        p = new int[n];
        r = new int[n];
        c = new int[n];
        Arrays.fill(c, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int[] edge : e) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            union(u, v);
        }
        
        for (int[] edge : e) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int rootU = find(u);
            c[rootU] &= w;
        }

        int[] result = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int s = q[i][0];
            int d = q[i][1];

            int rootS = find(s);
            int rootD = find(d);
            if (s == d) {
                result[i] = 0;
            } else if (rootS != rootD) {
                result[i] = -1;
            } else {
                result[i] = c[rootS];
            }
        }

        return result;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        if (r[rootX] < r[rootY]) {
            p[rootX] = rootY;
        } else if (r[rootY] < r[rootX]) {
            p[rootY] = rootX;
        } else {
            p[rootY] = rootX;
            r[rootX]++;
        }
    }
}