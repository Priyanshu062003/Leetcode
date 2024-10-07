class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s2.length() > s1.length()) return areSentencesSimilar(s2,s1);
        String arr1[] = s1.split(" ");
        String arr2[] = s2.split(" ");
        
        int start = 0, end = 0;
        int n1 = arr1.length, n2 = arr2.length;

        while (start < n2 && arr1[start].equals(arr2[start])) start++;
        while (end < n2 && arr1[n1 - end - 1].equals(arr2[n2 - end - 1])) end++;

        return start + end >= n2;

    }
}