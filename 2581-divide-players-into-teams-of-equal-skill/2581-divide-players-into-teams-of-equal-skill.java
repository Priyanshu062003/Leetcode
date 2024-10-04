class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        int n = skill.length;
        int count[] = new int[2001];
        for(int i: skill) {
            sum += i;
            count[i]++;
        }
        
        // if(sum/n==1000) {
        //     int temp = 1000;
        //     if(count[temp]%2 == 1) return- 1L;
        //     return (long)count[temp]/2*((long)(temp)*(temp));
        // }
        int l = 1, r = (int)sum/(n/2)-1;
        long ans = 0L;
        while(l<r) {
            if(count[l] != count[r]) return -1L;
            ans +=(long) count[l]*(l*r);
            l++; r--;
        }
        if(l>r) return ans;
        if(count[l]%2 == 1) return-1L;
        ans += (long)count[l]/2*(l*l);
        
        return ans;
    }
}