class Solution {
    Queue<Integer> queue;
    Queue<Integer> buffer;
    /** Initialize your data structure here. */
    public Solution() {
      queue = new ArrayDeque<>();
      buffer = new ArrayDeque<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
      queue.offer(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        // if(queue == null) {
        //   return null;
        // } 不需要这一段，可以在下面判断；Integer可以是null
        Integer pre = queue.poll();
        Integer cur = queue.poll();
        while(cur != null) {
          buffer.offer(pre);
          pre = cur;
          cur = queue.poll();
        }
        //比较好的倒回去的方法，也可使用for loop（while ！.isEmpty())
        Queue temp = queue;
        queue = buffer;
        buffer = temp;
        return pre;
    }

    /** Get the top element. */
    public Integer top() {
        Integer res = pop();
        //这里必须要先判断res是不是null,如果是null,执行以下statment会报错
        if(res != null) {
          queue.offer(res);
        }
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
       return queue.isEmpty();
    }

}
