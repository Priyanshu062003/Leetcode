class Pair {
    int data, arr, idx;
    Pair(int d, int a, int i) {
        data = d;
        arr = a;
        idx = i;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums)
    {
        int k = nums.size();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) ->  a.data - b.data);

       for (int i=0; i<k; i++) {
            int ele = nums.get(i).get(0);
            min = Math.min(ele, min);
            max = Math.max(ele, max);
            pq.add(new Pair(ele,i,0));
       }
       int start = min;
       int end = max;

       while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int idx = curr.idx;
            int arr = curr.arr;
            int data = curr.data;
            min = data;

            if(max - min < end - start) {
                end = max;
                start = min;
            }
            int n = nums.get(arr).size();
            if (idx + 1 < n) {
                max = Math.max(nums.get(arr).get(idx+1),max);
                pq.add(new Pair(nums.get(arr).get(idx+1),arr,idx+1));
            }
            else break; 
       } 

       return new int[] {start,end};
    }
}

