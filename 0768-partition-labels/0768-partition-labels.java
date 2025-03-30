class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int count[] = new int[26];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) count[s.charAt(i) - 'a'] = i;

        int max = count[s.charAt(0) - 'a'];
        int start = 0;

        for(int i=0; i<n; i++) {
            max = Math.max(max,count[s.charAt(i) - 'a']);
            if(i == max ) {
                list.add(i-start + 1);
                start = i+1;
            }
        }

        return list;
    }
}