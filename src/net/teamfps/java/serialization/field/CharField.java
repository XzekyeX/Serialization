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
public class CharField extends Field {
	private char data;

	public CharField(String name, char data) {
		super(name, Type.CHAR);
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
	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public void addData(char data) {
		this.data += data;
	}

	public void subData(char data) {
		this.data -= data;
	}

	public void divData(char data) {
		this.data /= data;
	}

	public void mulData(char data) {
		this.data *= data;
	}

	public boolean equals(CharField other) {
		return (getData() == other.getData()) && (getName().equals(other.getName()));
	}

	public static CharField to(Container c) {
		return (c != null && c instanceof CharField) ? (CharField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + data + "))";
	}

}
