class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0L;
        boolean even = true;
        boolean zeros = false;
        int min = 1000000;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sum = (sum + Math.abs(matrix[i][j]));
                if(matrix[i][j] <0) even = !even;
                min = Math.min(min,Math.abs(matrix[i][j]));
                if(matrix[i][j] == 0) zeros = true;
            }
        }
        if(zeros || even) return sum;
        return (sum-2*min)+0L;
    }
}