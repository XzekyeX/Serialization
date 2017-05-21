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
public class ByteField extends Field {
	private byte data;

	public ByteField(String name, byte data) {
		super(name, Type.BYTE);
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
	public byte getData() {
		return data;
	}

	public void setData(byte data) {
		this.data = data;
	}

	public void addData(byte data) {
		this.data += data;
	}

	public void subData(byte data) {
		this.data -= data;
	}

	public void divData(byte data) {
		this.data /= data;
	}

	public void mulData(byte data) {
		this.data *= data;
	}

	public boolean equals(ByteField other) {
		return (getData() == other.getData()) && (getName().equals(other.getName()));
	}

	public static ByteField to(Container c) {
		return (c != null && c instanceof ByteField) ? (ByteField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + toStr(data) + "))";
	}

}
