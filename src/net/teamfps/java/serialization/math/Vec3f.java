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
public class Vec3f extends ContainerObject {
	protected FloatField x, y, z;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vec3f(float x, float y, float z) {
		this("Vec3", x, y, z);
	}

	/**
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vec3f(String name, float x, float y, float z) {
		super(name);
		this.x = new FloatField("x", x);
		this.y = new FloatField("y", y);
		this.z = new FloatField("z", z);
		this.add(this.x);
		this.add(this.y);
		this.add(this.z);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return this
	 */
	public Vec3f set(float x, float y, float z) {
		this.x.setData(x);
		this.y.setData(y);
		this.z.setData(z);
		return this;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return this
	 */
	public Vec3f add(float x, float y, float z) {
		this.x.addData(x);
		this.y.addData(y);
		this.z.addData(z);
		return this;
	}

	/**
	 * 
	 * @param Vec3f
	 * @return this
	 */
	public Vec3f add(Vec3f v) {
		this.x.addData(v.getX());
		this.y.addData(v.getY());
		this.z.addData(v.getZ());
		return this;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return this
	 */
	public Vec3f sub(float x, float y, float z) {
		this.x.subData(x);
		this.y.subData(y);
		this.z.subData(z);
		return this;
	}

	/**
	 * 
	 * @param Vec3f
	 * @return this
	 */
	public Vec3f sub(Vec3f v) {
		this.x.subData(v.getX());
		this.y.subData(v.getY());
		this.z.subData(v.getZ());
		return this;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return this
	 */
	public Vec3f div(float x, float y, float z) {
		this.x.divData(x);
		this.y.divData(y);
		this.z.divData(z);
		return this;
	}

	/**
	 * 
	 * @param Vec3f
	 * @return this
	 */
	public Vec3f div(Vec3f v) {
		this.x.divData(v.getX());
		this.y.divData(v.getY());
		this.z.divData(v.getZ());
		return this;
	}

	/**
	 * 
	 * @param Vec3f
	 * @return this
	 */
	public Vec3f mul(float x, float y, float z) {
		this.x.mulData(x);
		this.y.mulData(y);
		this.z.mulData(z);
		return this;
	}

	/**
	 * 
	 * @param Vec3f
	 * @return this
	 */
	public Vec3f mul(Vec3f v) {
		this.x.mulData(v.getX());
		this.y.mulData(v.getY());
		this.z.mulData(v.getZ());
		return this;
	}

	/**
	 * 
	 * @param Vec3f
	 * @return creates new increased Vec3f
	 */
	public Vec3f increase(Vec3f v) {
		return new Vec3f(getX() + v.getX(), getY() + v.getY(), getZ() + v.getZ());
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return creates new increased Vec3f
	 */
	public Vec3f increase(float x, float y, float z) {
		return new Vec3f(getX() + x, getY() + y, getZ() + z);
	}

	/**
	 * 
	 * @param Vec3f
	 * @return creates new subtracted Vec3f
	 */
	public Vec3f subtract(Vec3f v) {
		return new Vec3f(getX() - v.getX(), getY() - v.getY(), getZ() - v.getZ());
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return creates new subtracted Vec3f
	 */
	public Vec3f subtract(float x, float y, float z) {
		return new Vec3f(getX() - x, getY() - y, getZ() - z);
	}

	/**
	 * 
	 * @param Vec3f
	 * @return creates new divided Vec3f
	 */
	public Vec3f divide(Vec3f v) {
		return new Vec3f(getX() / v.getX(), getY() / v.getY(), getZ() / v.getZ());
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return creates new divided Vec3f
	 */
	public Vec3f divide(float x, float y, float z) {
		return new Vec3f(getX() / x, getY() / y, getZ() / z);
	}

	/**
	 * 
	 * @param Vec3f
	 * @return creates new multiplied Vec3f
	 */
	public Vec3f multiply(Vec3f v) {
		return new Vec3f(getX() * v.getX(), getY() * v.getY(), getZ() * v.getZ());
	}

	public Vec3f multiply(float v) {
		return new Vec3f(getX() * v, getY() * v, getZ() * v);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return creates new multiplied Vec3f
	 */
	public Vec3f multiply(float x, float y, float z) {
		return new Vec3f(getX() * x, getY() * y, getZ() * z);
	}

	public float dot(Vec3f r) {
		return getX() * r.getX() + getY() * r.getY() + getZ() * r.getZ();
	}

	public float length() {
		return (float) Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
	}

	public Vec3f normalized() {
		float length = length();
		float x = getX() / length;
		float y = getY() / length;
		float z = getZ() / length;
		return new Vec3f(x, y, z);
	}

	public Vec3f normalize() {
		float invLength = 1.0f / length();
		x.mulData(invLength);// *= invLength;
		y.mulData(invLength);// *= invLength;
		z.mulData(invLength);// *= invLength;
		return this;
	}

	public static Vec3f normalize(Vec3f v) {
		return new Vec3f(v.getX(), v.getY(), v.getZ()).normalized();
	}

	public Vec3f rotate(Vec3f axis, float a) {
		float angle = (float) Math.toRadians(a);
		float sin = (float) Math.sin(-angle);
		float cos = (float) Math.cos(-angle);
		float cosMin = 1 - cos;
		float dot = getX() * axis.getX() * cosMin + getY() * axis.getY() * cosMin + getZ() * axis.getZ() * cosMin;
		float x = (getY() * axis.getZ() * sin - getZ() * axis.getY() * sin) + getX() * cos + axis.getX() * dot;
		float y = (getZ() * axis.getX() * sin - getX() * axis.getZ() * sin) + getY() * cos + axis.getY() * dot;
		float z = (getX() * axis.getY() * sin - getY() * axis.getX() * sin) + getZ() * cos + axis.getZ() * dot;
		return new Vec3f(x, y, z);
	}

	public Vec3f cross(Vec3f r) {
		float x = getY() * r.getZ() - getZ() * r.getY();
		float y = getZ() * r.getX() - getX() * r.getZ();
		float z = getX() * r.getY() - getY() * r.getX();
		return new Vec3f(x, y, z);
	}

	public Vec3f cross(Vec3f v, Vec3f dest) {
		return dest.set(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}

	public Vec3f lerp(Vec3f other, float amount) {
		float x = lerp(getX(), other.getX(), amount);
		float y = lerp(getY(), other.getY(), amount);
		float z = lerp(getZ(), other.getZ(), amount);
		return new Vec3f(x, y, z);
	}

	public float lerp(float value1, float value2, float amount) {
		return value1 + (value2 - value1) * amount;
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

	/**
	 * @return the z
	 */
	public float getZ() {
		return z.getData();
	}

	public void addX(float value) {
		x.addData(value);
	}

	public void addY(float value) {
		y.addData(value);
	}

	public void addZ(float value) {
		z.addData(value);
	}

	public void setX(float value) {
		this.x.setData(value);
	}

	public void setY(float value) {
		this.y.setData(value);
	}

	public void setZ(float value) {
		this.z.setData(value);
	}

	public void subX(float value) {
		this.x.subData(value);
	}

	public void subY(float value) {
		this.y.subData(value);
	}

	public void subZ(float value) {
		this.z.subData(value);
	}

	public Vec3f neg() {
		return new Vec3f(-getX(), -getY(), -getZ());
	}

	public static float[] toFloatArray(List<Vec3f> list) {
		float[] result = new float[list.size() * 3];
		int i = 0;
		for (Vec3f v : list) {
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
	public boolean equals(Vec3f other) {
		return (x.equals(other.x) && y.equals(other.y) && z.equals(other.z));
	}

	@Override
	public String toString() {
		return "Vec3f(X = " + String.format("%.2f", getX()) + ", Y = " + String.format("%.2f", getY()) + ", Z = " + String.format("%.2f", getZ()) + ")";
	}

//	public Vec3f mulProject(Matrix4f matrix4f) {
//		return null;
//	}

	public void div(float w) {
		x.divData(w);
		y.divData(w);
		z.divData(w);
	}

}
