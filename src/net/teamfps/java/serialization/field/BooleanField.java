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
public class BooleanField extends Field {
	private boolean data;

	public BooleanField(String name, boolean data) {
		super(name, Type.BOOLEAN);
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
	public boolean getData() {
		return data;
	}

	public void setData(boolean data) {
		this.data = data;
	}

	public boolean equals(BooleanField other) {
		return (getData() == other.getData()) && (getName().equals(other.getName()));
	}

	public static BooleanField to(Container c) {
		return (c != null && c instanceof BooleanField) ? (BooleanField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + data + "))";
	}

}
