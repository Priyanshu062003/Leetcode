class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = n+1;
        long presum[] = new long[n+1];
        presum[0] = 0;
        Deque<Integer> dq = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            presum[i] = presum[i-1]+nums[i-1];
        }
        System.out.println(Arrays.toString(presum));
        for ( int i=0; i<=n; i++) {
            while(!dq.isEmpty() && presum[dq.getLast()]>=presum[i]) {
                dq.removeLast();
            }
            while(!dq.isEmpty() && presum[i]-presum[dq.getFirst()] >= k) {
            System.out.println(presum[dq.getFirst()]);
                ans = Math.min(ans,i-dq.removeFirst());
            }
            dq.addLast(i);
        }
        return ans<=n? ans:-1;

    }
}