package org.contest;

import java.util.PriorityQueue;

/**
 * @author: yuanrui
 */
public class Case2024083104 {
	static class Enemy {
		int damage;
		int health;
		int index;
		Enemy(int damage, int health, int index) {
			this.damage = damage;
			this.health = health;
			this.index = index;
		}
	}


	public long minDamage(int power, int[] damage, int[] health) {
		int n = damage.length;
		long ans = 0;
		long curDamage = 0;
		PriorityQueue<Enemy> maxHeap = new PriorityQueue<>((e1, e2) -> {
			double ratio1 = e1.damage / Math.ceil((double) e1.health / power);
			double ratio2 = e2.damage / Math.ceil((double) e2.health / power);
			return Double.compare(ratio2, ratio1);
		});
		for (int i = 0; i < n; i++) {
			maxHeap.offer(new Enemy(damage[i], health[i], i));
			curDamage += damage[i];
		}
		while (!maxHeap.isEmpty()) {
			ans += curDamage;
			Enemy current = maxHeap.poll();
			current.health -= power;
			if (current.health > 0) {
				maxHeap.offer(new Enemy(current.damage, current.health, current.index));
			} else {
				curDamage -= current.damage;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int power = 62;
		int[] damage = {80,79};
		int[] health = {86, 13};
		Case2024083104 case2024083104 = new Case2024083104();
		System.out.println(case2024083104.minDamage(power, damage, health));
	}
}
