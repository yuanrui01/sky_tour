package org.os;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 定义筷子类
class Chopstick {
    // 使用ReentrantLock来控制对筷子的访问
    private final Lock lock = new ReentrantLock();

    // 尝试拿起筷子
    public boolean pickUp() {
        return lock.tryLock();  // 如果锁定成功，则返回true，否则返回false
    }

    // 放下筷子
    public void putDown() {
        lock.unlock();  // 释放锁
    }
}

// 定义哲学家类，继承Thread类
class Philosopher extends Thread {
    private final int id;  // 哲学家的编号
    private final Chopstick leftChopstick;  // 左边的筷子
    private final Chopstick rightChopstick;  // 右边的筷子

    // 构造方法，初始化哲学家的编号及其左右两根筷子
    public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    // 哲学家思考的方法
    private void think() {
        System.out.println("Philosopher " + id + " is thinking.");
        try {
            // 模拟思考一段时间
            Thread.sleep((long) (Math.random() * 10));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // 恢复中断状态
        }
    }

    // 哲学家吃饭的方法
    private void eat() {
        System.out.println("Philosopher " + id + " is eating.");
        try {
            // 模拟吃饭一段时间
            Thread.sleep((long) (Math.random() * 10));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // 恢复中断状态
        }
    }

    // 哲学家的运行方法，包含其行为逻辑
    @Override
    public void run() {
        while (true) {  // 不断重复思考和尝试进餐的过程
            think();  // 哲学家思考
            if (leftChopstick.pickUp()) {  // 尝试拿起左边的筷子
                try {
                    if (rightChopstick.pickUp()) {  // 尝试拿起右边的筷子
                        try {
                            eat();  // 拿到两根筷子后开始吃饭
                        } finally {
                            rightChopstick.putDown();  // 放下右边的筷子
                        }
                    }
                } finally {
                    leftChopstick.putDown();  // 放下左边的筷子
                }
            }
        }
    }
}

// 定义主类，包含主方法
public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;  // 定义哲学家的数量
        Philosopher[] philosophers = new Philosopher[numPhilosophers];  // 创建哲学家数组
        Chopstick[] chopsticks = new Chopstick[numPhilosophers];  // 创建筷子数组

        // 初始化筷子
        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Chopstick();
        }

        // 初始化哲学家，并将其左右筷子传递给对应的哲学家
        for (int i = 0; i < numPhilosophers; i++) {
            Chopstick leftChopstick = chopsticks[i];
            Chopstick rightChopstick = chopsticks[(i + 1) % numPhilosophers];
            philosophers[i] = new Philosopher(i, leftChopstick, rightChopstick);
            philosophers[i].start();
        }
    }
}

