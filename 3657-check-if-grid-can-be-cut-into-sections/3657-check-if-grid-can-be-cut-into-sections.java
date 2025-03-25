class Solution {
    public boolean checkValidCuts(int n, int[][] rect) {
        int m = rect.length;
        int hori[][] = new int[m][2];
        int vert[][] = new int[m][2];

        for(int i=0; i<m; i++) {
            hori[i][0] = rect[i][1];
            hori[i][1] = rect[i][3];
            vert[i][0] = rect[i][0];
            vert[i][1] = rect[i][2];
        }

        Arrays.sort(hori,(a,b)-> a[0] - b[0]);
        Arrays.sort(vert,(a,b)-> a[0] - b[0]);

        int cnt = 2;
        int max = hori[0][1];
        for(int i=1; i<m; i++) {
            if(max <= hori[i][0]) cnt--;
            max = Math.max(max,hori[i][1]);
            if(cnt<=0) return true;
        }

        cnt = 2;
        max = vert[0][1];

        for(int i=1; i<m; i++) {
            if(max<=vert[i][0]) cnt--;
            max = Math.max(max,vert[i][1]);
            if(cnt<=0) return true;
        }

        return false;

        
    }
}