class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k == 1) return 'a';
        long len = 1; int n = operations.length;
        long nk = 0;
        int opr = 0;
        
        for(int i=0; i<n; i++) {
            len *= 2;
            if(len>=k) {
                nk = k - len/2;
                opr = operations[i];
                break;
            }
        }

        char ch = kthCharacter(nk,operations);
        if(opr == 0) return ch;
        if(ch == 'z') return 'a';

        return (char)(ch+1);
    }
}