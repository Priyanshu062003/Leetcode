class Dll {
    int val; Dll prev, next;
    Dll(int v) {
        prev = null;
        next = null;
        val = v;
    }
}
class MyCircularDeque {
    int size;
    int curr = 0;
    Dll head = null;
    Dll tail = head;
    public MyCircularDeque(int k) {
        size = k;
    }
    
    public boolean insertFront(int value) {
        if(curr == size) return false;
        Dll node = new Dll(value);
        if(head == null) {
            head = node;
            tail = node;
            curr++;
            return true;
        }
        if(tail == null) tail = head;
        node.next = head;
        head.prev = node;
        head = node;
        curr++;
        System.out.println(head.val+" "+tail.val);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(curr == size) return false;
        Dll node = new Dll(value);
        if(tail == null) {
            tail = node;
            head = node;
            curr++;
            return true;
        }
        node.prev = tail;
        tail.next = node;
        tail = node;
        curr++;
        return true;
    }
    
    public boolean deleteFront() {
        if(head == null) return false;
        curr--;
        if(curr == 0) {
            tail = null;
            head = null;
            return true;
        }
        head = head.next;
        return true;
    }
    
    public boolean deleteLast() {
        if(tail == null) return false;
        curr--;
        if(curr == 0) {
            tail = null;
            head = null;
            return true;
        }
        tail = tail.prev;
        return true;
    }
    
    public int getFront() {
        if(head == null) return -1;
        return head.val;
    }
    
    public int getRear() {
        if(tail == null) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return curr == 0;
    }
    
    public boolean isFull() {
        return curr == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */