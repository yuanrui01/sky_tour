package org.easy;


/**
 * 面试题 03.01. 三合一
 */
public class TripleInOne {

    private final int[] stacks;
    private final int stackSize;
    private final int[] ix;

    public TripleInOne(int stackSize) {
        this.stacks = new int[stackSize*3];
        this.stackSize = stackSize;
        ix = new int[3];
    }

    public void push(int stackNum, int value) {
        if (ix[stackNum] == stackSize) return;
        stacks[stackNum*stackSize + ix[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        return stacks[stackNum * stackSize + --ix[stackNum]];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        return stacks[stackNum * stackSize + ix[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return ix[stackNum] == 0;
    }
}
