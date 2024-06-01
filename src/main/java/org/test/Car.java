package org.test;

/**
 * Cloneable接口实验
 */
public class Car implements Cloneable{

	private int num;

	private int price;

	private String type;

	public Car(int num, int price, String type) {
		this.num = num;
		this.price = price;
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Car))
			return false;
		Car o1 = (Car) o;
		return o1.price == this.price && o1.num == this.num && o1.type.equals(this.type);
	}

	@Override
	public String toString() {
		return String.format("Car(num = %s, price = %s, type = %s)", num, price, type);
	}

	@Override
	public Car clone() {
		try {
			return (Car) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e); // 不会发生
		}
	}

	public static void main(String[] args) {
		Car car = new Car(1, 2, "23");
		System.out.println(car);
		Car clone = car.clone();
		System.out.println(clone);
		System.out.println(clone == car);
		System.out.println(clone.equals(car));

		int[] nums = {1,2,3,4,5};

		int[] clone1 = nums.clone();

	}
}

