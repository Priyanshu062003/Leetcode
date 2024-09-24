class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for(int i: arr1) {
            String temp = ""+i;

            for(int j=0; j<temp.length(); j++) {
                set1.add(temp.substring(0,j+1));
            }
        }
        for(int i: arr2) {
            String temp = ""+i;

            for(int j=0; j<temp.length(); j++) {
                set2.add(temp.substring(0,j+1));
            }
        }
        int ans = 0;
        for(String prefix: set1) {
            if(set2.contains(prefix)) {
                ans = Math.max(ans,prefix.length());
            }
        }
        return ans;
    }
}