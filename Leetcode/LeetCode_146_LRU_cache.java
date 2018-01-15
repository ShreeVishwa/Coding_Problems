class LRUCache {
    
    private class Node{
        int key,value;
        Node prev,next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0,0);
        }
    }
    
    private int count = 0, capacity;
    HashMap<Integer,Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new Node();
        tail = new Node();
        map = new HashMap<Integer,Node>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null) return -1;
        update(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n == null){
            n = new Node(key,value);
            map.put(key,n);
            add(n);
            count++;
        }
        else {
            n.value = value;
            update(n);
        }
        if(count > capacity){
            Node del = tail.prev;
            remove(del);
            map.remove(del.key);
            count--;
        }
    }
    
    public void update(Node node){
        remove(node);
        add(node);
    }
    
    public void remove(Node node){
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
    
    public void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */