class MyLinkedList {
    int index;
    ListNode head;
    ListNode tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        index = -1;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int in) {
        if(in > index){
          return -1;
        }
        int i = 0;
        ListNode cur = head;
        while(i < in){
            cur = cur.next;
            i++;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        if(head == null){
          head = newHead;
          tail = newHead;
        }else{
          newHead.next = head;
          head = newHead;
        }
        index++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        if(tail == null){
          head = newTail;
          tail = newTail;
          return;
        }else{
          tail.next = newTail;
          tail = newTail;
        }
        index++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int in, int val) {
        if(in > index){
          return;
        }
        if(in == 0){
          addAtHead(val);
          return;
        }
        if(in == index+1){
          addAtTail(val);
          return;
        }
        int i = 0;
        ListNode cur = head;
        ListNode prev = null;
        while(i < in){
            prev = cur;
            cur = cur.next;
            i++;
        }
        ListNode newNode = new ListNode(val);
        prev.next = newNode;
        newNode.next = cur;
        index++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int in) {
        if(in > index){
          return;
        }
        if(in == 0){
          ListNode newHead = head.next;
          head.next = null;
          head = newHead;
          index--;
          return;
        }
        int i = 0;
        ListNode cur = head;
        ListNode prev = null;
        while(i < in){
            prev = cur;
            cur = cur.next;
            i++;
        }
        prev.next = cur.next;
        cur.next = null;
        if(in == index){
          tail = prev;
        }
        index--;
    }
    private static class ListNode{
      int val;
      ListNode next;
      ListNode(int val){
        this.val = val;
        next = null;
      }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
