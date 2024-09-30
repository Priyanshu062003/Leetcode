class Node {
    int val; Node next, prev;
    Node(int v) {
        val = v;
    }
}
class CustomStack {

    Node head = new Node(-1);
    Node tail = head;
    int maxSize = 0;
    int size = 0;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    //3
    //201,202,103
    public void push(int x) {
        System.out.println(size);
        if(size == maxSize) return;
        Node temp = new Node(x);
        temp.prev = tail;
        temp.next = null;
        tail.next = temp;
        tail = temp;
        size++;
    }
    
    public int pop() {
        if(head == tail) return -1;
        size--;
        int val = tail.val;
        tail = tail.prev;
        return val;
    }
    
    public void increment(int k, int val) {
        Node temp = head.next;
        int count = 0;
        while(temp != null && count<k) {
            temp.val += val;
            System.out.println(temp.val);
            temp = temp.next;
            count++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */