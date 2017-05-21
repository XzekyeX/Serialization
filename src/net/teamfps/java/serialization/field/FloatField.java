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
public class FloatField extends Field {
	private float data;

	public FloatField(String name, float data) {
		super(name, Type.FLOAT);
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
	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}

	public void addData(float data) {
		this.data += data;
	}

	public void subData(float data) {
		this.data -= data;
	}

	public void divData(float data) {
		this.data /= data;
	}

	public void mulData(float data) {
		this.data *= data;
	}

	public boolean equals(FloatField other) {
		return (getData() == other.getData()) && (getName().equals(other.getName()));
	}

	public static FloatField to(Container c) {
		return (c != null && c instanceof FloatField) ? (FloatField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + data + "))";
	}

}
