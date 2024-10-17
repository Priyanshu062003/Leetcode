class Solution {
    public int maximumSwap(int num) {
        char arr[] = (num+"").toCharArray();
        int n = arr.length;

        for(int i=0; i<n; i++) {
            char great = '0';
            int idx = n;
            for(int j=n-1; j>i; j--) {
                if(arr[i] < arr[j] && great < arr[j]) {
                    idx = j;
                    great = arr[j];
                }
            }
            if(idx != n) {
                char temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;

                return Integer.parseInt(new String(arr));
            }
        }
        return num;

    }
}