class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;

        char[][] ans = new char[m][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                ans[j][i] = box[n-i-1][m-j-1];
            }
        }
        for(int i=0, j=m-1; i<j; i++,j--) {
            char temp[] = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
        }
        for(int i=m-1; i>=0; i--) {
            for(int j=0; j<n; j++) {
                // System.out.print(ans[i][j]);
                if(ans[i][j] == '#') {
                    int k = i;
                    while(k<m-1 && ans[k+1][j] == '.') {
                        char temp = ans[k][j];
                        ans[k][j] = ans[k+1][j];
                        ans[k+1][j] = temp;
                        k++;
                    }
                }
            }
            // System.out.println();
        }
        return ans;
    }
}