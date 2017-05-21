/**
 * 
 */
package net.teamfps.java.serialization.math;

import java.util.List;

import net.teamfps.java.serialization.ContainerObject;
import net.teamfps.java.serialization.field.FloatField;

/**
 * @author Zekye
 *
 */
public class Vec2f extends ContainerObject {
	protected FloatField x, y;

	public Vec2f(float x, float y) {
		this("Vec2", x, y);
	}

	public Vec2f(String name, float x, float y) {
		super(name);
		this.x = new FloatField("x", x);
		this.y = new FloatField("y", y);
		this.add(this.x);
		this.add(this.y);
	}

	public void set(float x, float y) {
		this.x.setData(x);
		this.y.setData(y);
	}

	public void add(float x, float y) {
		this.x.addData(x);
		this.y.addData(y);
	}

	public void sub(float x, float y) {
		this.x.subData(x);
		this.y.subData(y);
	}

	public void div(float x, float y) {
		this.x.divData(x);
		this.y.divData(y);
	}

	public void mul(float x, float y) {
		this.x.mulData(x);
		this.y.mulData(y);
	}

	public float dot(Vec2f r) {
		return getX() * r.getX() + getY() * r.getY();
	}

	public float length() {
		return (float) Math.sqrt(getX() * getX() + getY() * getY());
	}

	public Vec2f normalized() {
		float length = length();
		float x = getX() / length;
		float y = getY() / length;
		return new Vec2f(x, y);
	}

	public Vec2f rotate(float angle) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		return new Vec2f((float) (getX() * cos - getY() * sin), (float) (getX() * sin + getY() * cos));
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x.getData();
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y.getData();
	}

	public static float[] toFloatArray(List<Vec2f> list) {
		float[] result = new float[list.size() * 2];
		int i = 0;
		for (Vec2f v : list) {
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
	public boolean equals(Vec2f other) {
		return (x.equals(other.x) && y.equals(other.y));
	}

	@Override
	public String toString() {
		return "Vec2f(" + getX() + "," + getY() + ")";
	}

}
