class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    Node head = null;
    Node tail = null;
    int length = 0;
    public MyLinkedList() {}

    public int get(int index) {
        if (index < 0 || index >= length)
            return -1;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index > length)
            return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == length) {
            addAtTail(val);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length)
            return;

        if (index == 0) {
            head = head.next;
            if (length == 1) tail = null;
            length--;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        if (index == length - 1) {
            tail = current;
        }
        length--;
    }
}