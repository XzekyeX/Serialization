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
public class LongField extends Field {
	private long data;

	public LongField(String name, long data) {
		super(name, Type.LONG);
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
	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

	public void addData(long data) {
		this.data += data;
	}

	public void subData(long data) {
		this.data -= data;
	}

	public void divData(long data) {
		this.data /= data;
	}

	public void mulData(long data) {
		this.data *= data;
	}

	public boolean equals(LongField other) {
		return (getData() == other.getData()) && (getName().equals(other.getName()));
	}

	public static LongField to(Container c) {
		return (c != null && c instanceof LongField) ? (LongField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + data + "))";
	}
}
