package org.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * PhantomReference example
 */
public class PhantomReferenceExample {

	// 模拟需要清理的资源
	static class Resource {
		private final String name;

		public Resource(String name) {
			this.name = name;
		}

		// 模拟清理操作
		public void cleanup() {
			System.out.println("Cleaning up resource: " + name);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// 创建一个ReferenceQueue，用于接收PhantomReference的通知
		ReferenceQueue<Resource> queue = new ReferenceQueue<>();

		// 创建一个Resource对象
		Resource resource = new Resource("MyResource");

		// 创建PhantomReference，关联resource对象和queue
		PhantomReference<Resource> phantomRef = new PhantomReference<>(resource, queue);

		// 打印PhantomReference的状态
		System.out.println("PhantomReference created, resource is: " + phantomRef.get()); // 总是返回null

		// 让resource对象变为不可达（可以被垃圾回收）
		resource = null;

		// 提示GC运行（不保证立即执行）
		System.out.println("Suggesting GC...");
		System.gc();

		// 检查ReferenceQueue，看是否有PhantomReference被加入
		Reference<? extends Resource> ref = queue.remove(1000);// 阻塞最多1秒
		if (ref != null) {
			// 当PhantomReference出现在队列中时，说明关联的对象已被回收
			System.out.println("Resource has been garbage collected!");
			// 执行清理操作（这里假设我们有办法访问原始的Resource对象）
			// 在实际中，可能需要额外的映射机制来关联PhantomReference和Resource
			// 为了简化，这里直接调用cleanup（假设我们知道是哪个资源）
			// 实际场景中可能需要用WeakHashMap或其他方式保存Resource的引用

		} else {
			System.out.println("Resource not yet collected or GC not triggered.");
		}
	}
}
