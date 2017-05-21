/**
 * 
 */
package net.teamfps.java.serialization.math;

import net.teamfps.java.serialization.ContainerObject;
import net.teamfps.java.serialization.field.FloatField;

/**
 * @author Zekye
 *
 */
public class Vec4f extends ContainerObject {
	protected FloatField x, y, z, d;

	public Vec4f(String name, float x, float y, float z, float d) {
		super(name);
		this.x = new FloatField("x", x);
		this.y = new FloatField("y", y);
		this.z = new FloatField("z", z);
		this.d = new FloatField("d", d);
		this.add(this.x);
		this.add(this.y);
		this.add(this.z);
		this.add(this.d);
	}

	public void set(float x, float y, float z, float d) {
		this.x.setData(x);
		this.y.setData(y);
		this.z.setData(z);
		this.d.setData(d);
	}

	public void add(float x, float y, float z, float d) {
		this.x.addData(x);
		this.y.addData(y);
		this.z.addData(z);
		this.d.addData(d);
	}

	public void sub(float x, float y, float z, float d) {
		this.x.subData(x);
		this.y.subData(y);
		this.z.subData(z);
		this.d.subData(d);
	}

	public void div(float x, float y, float z, float d) {
		this.x.divData(x);
		this.y.divData(y);
		this.z.divData(z);
		this.d.divData(d);
	}

	public void mul(float x, float y, float z, float d) {
		this.x.mulData(x);
		this.y.mulData(y);
		this.z.mulData(z);
		this.d.mulData(d);
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

	/**
	 * @return the d
	 */
	public float getD() {
		return d.getData();
	}

	public void setX(float x) {
		this.x.setData(x);
	}

	public void setY(float y) {
		this.y.setData(y);
	}

	public void setZ(float z) {
		this.z.setData(z);
	}

	public void setD(float d) {
		this.d.setData(d);
	}

	/**
	 * 
	 * @param other
	 * @return returns true if and only if name and positions are same
	 */
	public boolean equals(Vec4f other) {
		return (x.equals(other.x) && y.equals(other.y) && z.equals(other.z));
	}
//
//	public Vec4f mul(Matrix4f matrix4f) {
//		return null;
//	}
//
//	public Vec4f mulProject(Matrix4f matrix4f) {
//		return null;
//	}

	public void div(float r) {
		x.divData(r);
		y.divData(r);
		z.divData(r);
		d.divData(r);
	}
}
