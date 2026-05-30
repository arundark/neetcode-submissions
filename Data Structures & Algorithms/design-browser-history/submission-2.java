class Node {
    String url;
    Node previous;
    Node next;

    public Node(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    Node head;
    Node current;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        current = head;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = newNode;
        newNode.previous = current;
        current = newNode;
    }

    public String back(int steps) {
        int i = 0;
        while (i < steps) {
            if (current.previous == null)
                break;
            current = current.previous;
            i++;
        }
        return current.url;
    }

    public String forward(int steps) {
        int i = 0;
        while (i < steps) {
            if (current.next == null)
                break;
            current = current.next;
            i++;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */