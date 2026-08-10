class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if (map.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) {
        Node prev = right.prev;
        Node next = right;

        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }
}