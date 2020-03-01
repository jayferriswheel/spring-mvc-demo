package com.carto.leetcode.round1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 坑：
 * 1、使用两个队列的话，不能直接赋值，会导致后面删除新增有影响
 * 2、可以用size，来判断最后一个，比empty好用
 * 3、保存top，可以使得top返回更快
 *
 * 我希望不仅可以完成，还可以漂亮的完成
 */
class MyStack {

    private Queue<Integer> queue1 = new LinkedList<>();

    private Queue<Integer> queue2 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue1.isEmpty()) return 0;
        int top = 0;
        while (!queue1.isEmpty()) {
            queue2.add(top);
            top = queue1.poll();
        }
        queue1.addAll(queue2);
        queue2.clear();
        return top;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue1.isEmpty()) return 0;
        int top = queue1.peek();
        while (!queue1.isEmpty()) {
            int i = queue1.poll();
            queue2.add(i);
            top = i;
        }
        queue1.addAll(queue2);
        queue2.clear();
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */