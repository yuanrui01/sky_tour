package org.test;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * @author: yuanrui
 */
public class ReachabilityFenceExample {

	static class Resource {
		private final String id;

		public Resource(String id) {
			this.id = id;
		}

		public void use() throws InterruptedException {
			System.gc();
			System.out.println("Using resource: " + id);
			//Reference.reachabilityFence(this);
			Thread.sleep(2000);
			System.out.println(this);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// 假设这里是关键操作，JIT可能优化认为res不再需要
		new Resource("1323").use();
	}
}
