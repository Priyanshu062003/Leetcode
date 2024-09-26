class MyCalendar {
    TreeMap<Integer,Integer> map = new TreeMap<>();
    public MyCalendar() {
        map.put(Integer.MAX_VALUE,Integer.MAX_VALUE);
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> pair = map.higherEntry(start);
        System.out.println(pair);
        boolean res = end <= pair.getValue();
        if (res) map.put(end, start);
        return res;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */