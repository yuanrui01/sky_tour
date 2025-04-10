package org.queue;

/**
 * 622. 设计循环队列
 */
public class MyCircularQueue {

	private int[] memo;
	private int n;

	private int front = 0;
	private int rear = 0;

	public MyCircularQueue(int k) {
		n = k + 1;
		memo = new int[n];
	}

	public boolean enQueue(int value) {
		if (isFull()) return false;
		memo[rear] = value;
		rear = (rear + 1) % n;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) return false;
		front = (front + 1) % n;
		return true;
	}

	public int Front() {
		return isEmpty() ? -1 : memo[front];
	}

	public int Rear() {
		return isEmpty() ? -1 : memo[(rear - 1 + n) % n];
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (rear + 1) % n == front;
	}
}
