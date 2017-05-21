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
public class IntField extends Field {
	private int data;

	public IntField(String name, int data) {
		super(name, Type.INT);
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
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void addData(int data) {
		this.data += data;
	}

	public void subData(int data) {
		this.data -= data;
	}

	public void divData(int data) {
		this.data /= data;
	}

	public void mulData(int data) {
		this.data *= data;
	}

	public boolean equals(IntField other) {
		return (getData() == other.getData()) && (getName().equals(other.getName()));
	}

	public static IntField to(Container c) {
		return (c != null && c instanceof IntField) ? (IntField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + data + "))";
	}

}
