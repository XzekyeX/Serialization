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
public class ShortField extends Field {
	private short data;

	public ShortField(String name, short data) {
		super(name, Type.SHORT);
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
	public short getData() {
		return data;
	}

	public void setData(short data) {
		this.data = data;
	}

	public void addData(short data) {
		this.data += data;
	}

	public void subData(short data) {
		this.data -= data;
	}

	public void divData(short data) {
		this.data /= data;
	}

	public void mulData(short data) {
		this.data *= data;
	}

	public boolean equals(ShortField other) {
		return (getData() == other.getData()) && (getName().equals(other.getName()));
	}

	public static ShortField to(Container c) {
		return (c != null && c instanceof ShortField) ? (ShortField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + data + "))";
	}

}
