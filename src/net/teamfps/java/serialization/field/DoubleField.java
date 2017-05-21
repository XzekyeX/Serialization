/**
 * 
 */
package net.teamfps.java.serialization.field;

import static net.teamfps.java.serialization.Utils.*;

import net.teamfps.java.serialization.Container;
import net.teamfps.java.serialization.Type;

/**
 * @author Zekye
 *
 */
public class DoubleField extends Field {
	private double data;

	public DoubleField(String name, double data) {
		super(name, Type.DOUBLE);
		this.data = data;
	}

	@Override
	public int getSize() {
		return Type.BYTE.getSize() + Type.SHORT.getSize() + name.length + Type.BYTE.getSize() + type.getSize();
	}

	@Override
	public int setBytes(byte[] dest, int pointer) {
		pointer = writeBytes(dest, pointer, CONTAINER_TYPE.getType());
		pointer = writeBytes(dest, pointer, nameLength);
		pointer = writeBytes(dest, pointer, name);
		pointer = writeBytes(dest, pointer, type.getType());
		pointer = writeBytes(dest, pointer, data);
		return pointer;
	}

	/**
	 * @return the data
	 */
	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public void addData(double data) {
		this.data += data;
	}

	public void subData(double data) {
		this.data -= data;
	}

	public void divData(double data) {
		this.data /= data;
	}

	public void mulData(double data) {
		this.data *= data;
	}

	public boolean equals(DoubleField other) {
		return (getData() == other.getData()) && (getName().equals(other.getName()));
	}

	public static DoubleField to(Container c) {
		return (c != null && c instanceof DoubleField) ? (DoubleField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + data + "))";
	}

}
