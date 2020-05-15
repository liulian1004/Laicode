class MyCircularQueue {
  // a circular array
  // head point to null. tail points to the buck that want to inserr the elemen
    int[] array;
    int head;
    int tail;
    int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array = new int[k+1];
        head = 0;
        tail = 1;
        size = k +1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) {
          return false;
        }
        array[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
          return false;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
         if(isEmpty()) {
          return -1;
        }
        return array[(head + 1) % size];
    }

    /** Get the last item from the queue. */
    public int Rear() {
         if(isEmpty()) {
          return -1;
        }
        return array[(tail -1+size) % size];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return  (head + 1) % size == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return tail == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
