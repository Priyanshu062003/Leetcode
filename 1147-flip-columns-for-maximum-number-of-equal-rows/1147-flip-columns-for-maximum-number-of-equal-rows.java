class Solution {
    boolean equal(int i,int k, int matrix[][]) {
        boolean result = true;
        for(int j=0; j<matrix[0].length; j++) {
            if(matrix[i][j] != matrix[k][j]) {
                result = false;
                break;
            }
        }
        if(result) return true;
        for(int j=0; j<matrix[0].length; j++) {
            if(matrix[i][j] == matrix[k][j]) {
                return false;
            }
        }
        return true;
    }
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int ans = 1;

        for(int i=0; i<n; i++) {
            int count = 1;
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                if(equal(i,j,matrix)) count++;
            }
            ans = Math.max(ans,count);
        }

        return ans;

    }
}