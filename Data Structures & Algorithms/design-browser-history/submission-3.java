class ListNode {
    String val;
    ListNode prev, next;

    public ListNode(String val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public ListNode(String val) {
        this(val, null, null);
    }
}

public class BrowserHistory {
    private ListNode cur;

    public BrowserHistory(String homepage) {
        cur = new ListNode(homepage);
    }

    public void visit(String url) {
        cur.next = new ListNode(url, cur, null);
        cur = cur.next;
    }

    public String back(int steps) {
        while (cur.prev != null && steps > 0) {
            cur = cur.prev;
            steps--;
        }
        return cur.val;
    }

    public String forward(int steps) {
        while (cur.next != null && steps > 0) {
            cur = cur.next;
            steps--;
        }
        return cur.val;
    }
}