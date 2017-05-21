/**
 * 
 */
package net.teamfps.java.serialization.math;

import java.util.List;

import net.teamfps.java.serialization.ContainerObject;
import net.teamfps.java.serialization.field.IntField;

/**
 * @author Zekye
 *
 */
public class Vec2i extends ContainerObject {
	protected IntField x, y;

	public Vec2i(int x, int y) {
		this("Vec2", x, y);
	}

	public Vec2i(String name, int x, int y) {
		super(name);
		this.x = new IntField("x", x);
		this.y = new IntField("y", y);
		this.add(this.x);
		this.add(this.y);
	}

	public void set(int x, int y) {
		this.x.setData(x);
		this.y.setData(y);
	}

	public void add(int x, int y) {
		this.x.addData(x);
		this.y.addData(y);
	}

	public void sub(int x, int y) {
		this.x.subData(x);
		this.y.subData(y);
	}

	public void div(int x, int y) {
		this.x.divData(x);
		this.y.divData(y);
	}

	public void mul(int x, int y) {
		this.x.mulData(x);
		this.y.mulData(y);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x.getData();
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y.getData();
	}

	public static int[] toIntArray(List<Vec2i> list) {
		int[] result = new int[list.size() * 2];
		int i = 0;
		for (Vec2i v : list) {
			result[i * 2] = v.getX();
			result[i * 2 + 1] = v.getY();
			i++;
		}
		return result;
	}

	/**
	 * 
	 * @param other
	 * @return returns true if and only if name and positions are same
	 */
	public boolean equals(Vec2i other) {
		return (x.equals(other.x) && y.equals(other.y));
	}

	@Override
	public String toString() {
		return "Vec2i(" + getX() + "," + getY() + ")";
	}
}
