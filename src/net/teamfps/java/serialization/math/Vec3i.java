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
public class Vec3i extends ContainerObject {
	protected IntField x, y, z;

	public Vec3i(int x, int y, int z) {
		this("Vec3", x, y, z);
	}

	public Vec3i(String name, int x, int y, int z) {
		super(name);
		this.x = new IntField("x", x);
		this.y = new IntField("y", y);
		this.z = new IntField("z", z);
		this.add(this.x);
		this.add(this.y);
		this.add(this.z);
	}

	public void set(int x, int y, int z) {
		this.x.setData(x);
		this.y.setData(y);
		this.z.setData(z);
	}

	public void add(int x, int y, int z) {
		this.x.addData(x);
		this.y.addData(y);
		this.z.addData(z);
	}

	public void sub(int x, int y, int z) {
		this.x.subData(x);
		this.y.subData(y);
		this.z.subData(z);
	}

	public void div(int x, int y, int z) {
		this.x.divData(x);
		this.y.divData(y);
		this.z.divData(z);
	}

	public void mul(int x, int y, int z) {
		this.x.mulData(x);
		this.y.mulData(y);
		this.z.mulData(z);
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

	/**
	 * @return the z
	 */
	public int getZ() {
		return z.getData();
	}

	public void addX(int value) {
		x.addData(value);
	}

	public void addY(int value) {
		y.addData(value);
	}

	public void addZ(int value) {
		z.addData(value);
	}

	public static int[] toIntArray(List<Vec3i> list) {
		int[] result = new int[list.size() * 3];
		int i = 0;
		for (Vec3i v : list) {
			result[i * 3] = v.getX();
			result[i * 3 + 1] = v.getY();
			result[i * 3 + 2] = v.getZ();
			i++;
		}
		return result;
	}

	/**
	 * 
	 * @param other
	 * @return returns true if and only if name and positions are same
	 */
	public boolean equals(Vec3i other) {
		return (x.equals(other.x) && y.equals(other.y) && z.equals(other.z));
	}

	@Override
	public String toString() {
		return "Vec3i(" + getX() + "," + getY() + "," + getZ() + ")";
	}
}
